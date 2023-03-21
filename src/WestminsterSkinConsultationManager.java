import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    public static void main(String[] args){
        WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();
        westminsterSkinConsultationManager.homePage();
    }
    public static ArrayList <Doctor> doctors=new ArrayList<>();
    public static void addToDoctorList(Doctor object) {doctors.add(object);}
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static void addToPatientList(Patient object) {patients.add(object);}
    public static ArrayList<Consultation> consultations = new ArrayList<>();

    public static void addToConsultationList(Consultation object) {consultations.add(object);}

    public void homePage(){
        Scanner input=new Scanner(System.in);
        readFile();//reads back all the information saved in the file
        while(true){
            System.out.println("Please Select An Option.");
            System.out.println("1 : Add Doctor\n2 : Delete Doctor\n3 : Print Doctors\n4 : Save in a file\n5 : GUI\n6 : Quit Program");
            int option=input.nextInt();
            input.nextLine();

            switch(option){
                case 1 :
                    addDoctor();
                    break;
                case 2 :
                    deleteDoctor();
                    break;
                case 3 :
                    printDoctor();
                    break;
                case 4 :
                    saveFile();
                    break;
                case 5:
                    GUI();
                    break;
                case 6 :
                    System.out.println("The End");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid output. Please try again");
            }
        }
    }
    public void addDoctor() {
        String firstName;
        String surName;
        String DOB;
        int mobileNo;
        String specialisation;

        if (doctors.size() > 9) {
            System.out.println("System is Full");
        } else {
            boolean check = true;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Medical License Number");
            while (true) {
                try {
                    int MLNum = Integer.parseInt(input.nextLine());
                    while (check) {
                        if (compareMedLicNo(MLNum)) {
                            System.out.println("Already Exists. Enter Another Medical License Number");
                            MLNum = Integer.parseInt(input.nextLine());
                        } else {
                            check = false;
                            System.out.println("Enter firstname");
                            firstName = input.nextLine().toUpperCase();
                            System.out.println("Enter Surname");
                            surName = input.nextLine().toUpperCase();
                            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                            Date date;
                            while (true) {
                                try {
                                    System.out.println("Enter Date of Birth (YYYY/MM/DD)");
                                    DOB = input.nextLine();
                                    date = df.parse(DOB);
                                    break;
                                } catch (ParseException e) {
                                    System.out.println("Wrong input type.");
                                }
                            }
                            System.out.println("Enter Mobile Number");
                            while (true) {
                                try {
                                    mobileNo = Integer.parseInt(input.nextLine());
                                    break;
                                }catch (Exception e) {
                                    System.out.println("Try Again. Enter Mobile Number");
                                }
                            }
                            System.out.println("Enter Specialisation");
                            specialisation = input.nextLine().toUpperCase();
                            Doctor doctor = new Doctor(firstName,surName,DOB,mobileNo,MLNum,specialisation);
                            addToDoctorList(doctor);
                        }
                    }
                    break;
                } catch (NumberFormatException n) {
                    System.out.println("Wrong input. Enter Another Medical License Number");
                }
            }
        }
    }
    public boolean compareMedLicNo(int medicalLicNo) {
        for (Doctor doctor : doctors) {
            if (medicalLicNo == doctor.getMedicalLicenceNumber()) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void deleteDoctor(){
        Scanner input=new Scanner(System.in);
        for (int j = 0; j < doctors.size(); j++) { //displays the doctor's full name and medical licence number
            System.out.println("Full Name : " + doctors.get(j).getSurname() +" " +doctors.get(j).getFirstname());
            System.out.println("Medical Licence No : " + doctors.get(j).getMedicalLicenceNumber()+"\n");
        }
        System.out.println("Enter Medical Licence Number");
        int deleteLicNo= input.nextInt(); //user will enter the medical licence number to be deleted

        for (int x = 0; x < doctors.size(); x++) {
            if(doctors.get(x).getMedicalLicenceNumber()==deleteLicNo){
                // displays the information of the doctor that has been deleted
                System.out.println("Full Name : " + doctors.get(x).getSurname() +" " +doctors.get(x).getFirstname());
                System.out.println("Date Of Birth : " + doctors.get(x).getDateOfBirth());
                System.out.println("Mobile Number : " + doctors.get(x).getMobileNumber());
                System.out.println("Medical Licence No : " + doctors.get(x).getMedicalLicenceNumber());
                System.out.println("Specialisation : " + doctors.get(x).getSpecialisation()+"\n");
                System.out.println("Doctor Deleted");
                doctors.remove(x); // removes the doctor from arraylist
                System.out.println("No Of Doctors In The Centre : " + doctors.size()); // displays total number of doctors in the centre
            }else{
                System.out.println("Not Found");
            }
        }
    }
    @Override
    public void printDoctor(){
        String [] arraySurname=new String[doctors.size()];
        //clones every surname to another array
        for (int i = 0; i < doctors.size(); i ++) {
            arraySurname[i]=doctors.get(i).getSurname();
        }
        //bubble sorting has been used to arrange surname in alphabetical order
        for (int i = 0; i < arraySurname.length; i++) {
            for (int j = i + 1; j < arraySurname.length; j++) {
                if (arraySurname[i].compareTo(arraySurname[j]) > 0){
                    String temp = arraySurname[i];
                    arraySurname[i] = arraySurname[j];
                    arraySurname[j] = temp;
                }
            }
        }
        //displays the name in alphabetical order and other relevant information
        for (int i = 0; i < arraySurname.length; i++) {
            for (int j = 0; j < arraySurname.length; j++) {
                if(arraySurname[i]==doctors.get(j).getSurname()){
                    System.out.println("Full Name : " + doctors.get(j).getSurname() +" " +doctors.get(j).getFirstname());
                    System.out.println("Date Of Birth : " + doctors.get(j).getDateOfBirth());
                    System.out.println("Mobile Number : " + doctors.get(j).getMobileNumber());
                    System.out.println("Medical Licence No : " + doctors.get(j).getMedicalLicenceNumber());
                    System.out.println("Specialisation : " + doctors.get(j).getSpecialisation()+"\n");
                }
            }
        }
    }
    @Override
    public void saveFile(){
        try{
            FileWriter myWriter = new FileWriter("doctor.txt"); //creates a file
            //saves all the information in alphabetical order
            String [] arraySurName=new String[doctors.size()];
            for (int i = 0; i < doctors.size(); i ++) {
                arraySurName[i]=doctors.get(i).getSurname();
            }
            for (int i = 0; i < arraySurName.length; i++) {
                for (int j = i + 1; j < arraySurName.length; j++) {
                    if (arraySurName[i].compareTo(arraySurName[j]) > 0) {
                        String temp = arraySurName[i];
                        arraySurName[i] = arraySurName[j];
                        arraySurName[j] = temp;
                    }
                }
            }
            for (int i = 0; i < arraySurName.length; i++) {
                for (int j = 0; j < arraySurName.length; j++) {
                    if(arraySurName[i]==doctors.get(j).getSurname()){
                        //.write is used to write the information in the files
                        myWriter.write("Full Name : " + doctors.get(j).getSurname() +" " +doctors.get(j).getFirstname()+"\n");
                        myWriter.write("Date Of Birth : " + doctors.get(j).getDateOfBirth()+"\n");
                        myWriter.write("Mobile Number : " + doctors.get(j).getMobileNumber()+"\n");
                        myWriter.write("Medical Licence No : " + doctors.get(j).getMedicalLicenceNumber()+"\n");
                        myWriter.write("Specialisation : " + doctors.get(j).getSpecialisation()+"\n\n");
                    }
                }
            }
            myWriter.close();//.close ends the writing of the file
            System.out.println("\nFile Saved.\n");
        }catch (IOException e){
            System.out.println("Error");
        }
    }
    public void readFile(){
        //read back all the information saved in the file and so that the user can continue to use the system
        try {
            File doctorFile = new File("doctor.txt");
            Scanner doctorFileReader = new Scanner(doctorFile);
            while (doctorFileReader.hasNextLine()) {
                String data = doctorFileReader.nextLine();
                System.out.println(data);
            }
            doctorFileReader.close();
        } catch (IOException e) {
            System.out.println("File Is Not Created.\n");
        }
    }

    public void GUI(){
        if (doctors.isEmpty()) {
            System.out.println("Please Enter Doctor Before Starting");
        } else {
            GUIPage1.doctorListDataTransfer(doctors); //transfer doctor array list data to GUIPage1
            GUIPage4.doctorListDataTransfer(doctors); //transfer doctor array list data to GUIPage4
            new GUIStart(); //calls the GUI
        }
    }
}
