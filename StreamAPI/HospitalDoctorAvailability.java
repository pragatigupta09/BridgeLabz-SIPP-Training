package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class HospitalDoctorAvailability {
    
    static class Doctor {
        private String name;
        private String specialty;
        private boolean availableOnWeekends;
        
        public Doctor(String name, String specialty, boolean availableOnWeekends) {
            this.name = name;
            this.specialty = specialty;
            this.availableOnWeekends = availableOnWeekends;
        }
        
        public String getSpecialty() { return specialty; }
        public boolean isAvailableOnWeekends() { return availableOnWeekends; }
        public String getName() { return name; }
    }
    
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Smith", "Cardiology", true),
            new Doctor("Dr. Johnson", "Neurology", false),
            new Doctor("Dr. Brown", "Cardiology", true),
            new Doctor("Dr. Wilson", "Pediatrics", true)
        );
        
        List<Doctor> availableDoctors = doctors.stream()
            .filter(Doctor::isAvailableOnWeekends)
            .sorted(Comparator.comparing(Doctor::getSpecialty))
            .collect(Collectors.toList());
        
        System.out.println("Doctors Available on Weekends:");
        availableDoctors.forEach(d -> System.out.println(d.getName() + " - " + d.getSpecialty()));
    }
}