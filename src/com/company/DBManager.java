package com.company;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public static final String url = "jdbc:postgresql://localhost/Hospital";
    public static final String user = "postgres";
    public static final String password = "72740304w";
    public static Connection connection;

    public static void connect(){
        try{
            connection = DriverManager.getConnection(url, user,password);
            System.out.println("Connected successfully to SQL DB");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Connected unsuccessfully to SQL DB");
        }
    }

    public static Boolean loginAdmin(Admin admin){
        Long id_a = admin.getId();
        String password = admin.getPassword();
        Boolean flag = false;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Admin\" WHERE id = ?");
            statement.setLong(1,id_a);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() && resultSet.getString("password").equals(password)){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Admin getAdmin(Admin admin){
        Admin result = null;
        Long id_a = admin.getId();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Admin\" WHERE id=?;");
            statement.setLong(1,id_a);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                int experience = resultSet.getInt("experience");
                String address = resultSet.getString("address");
                int salary = resultSet.getInt("salary");

                result = new Admin(id, password, name, surname, phone, experience, address, salary);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Admin> getAdmins(){
        ArrayList<Admin> admins = new ArrayList<Admin>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Admin\"");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                int experience = resultSet.getInt("experience");
                String address = resultSet.getString("address");
                int salary = resultSet.getInt("salary");

                admins.add(new Admin(id, password, name, surname, phone, experience, address, salary));
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return admins;
    }

    public static void addAdmin(Admin admin){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"Admin\" (\n" +
                    "password, name, surname, phone, experience, address, salary) VALUES (\n" +
                    "?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, admin.getPassword());
            statement.setString(2, admin.getName());
            statement.setString(3, admin.getSurname());
            statement.setString(4, admin.getPhone());
            statement.setInt(5, admin.getExperience());
            statement.setString(6, admin.getAddress());
            statement.setInt(7, admin.getSalary());

            int rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateAdmin(Admin admin){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Admin\" SET\n" +
                    "password = ?, name = ?, surname = ?, phone = ?, experience = ?, address = ?, salary = ? WHERE\n" +
                    "id = ?;");
            statement.setString(1, admin.getPassword());
            statement.setString(2, admin.getName());
            statement.setString(3, admin.getSurname());
            statement.setString(4, admin.getPhone());
            statement.setInt(5, admin.getExperience());
            statement.setString(6, admin.getAddress());
            statement.setInt(7, admin.getSalary());
            statement.setLong(8, admin.getId());

            int rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean deleteAdmin(Admin admin){
        Long id_a = admin.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.\"Admin\"\n" +
                    "WHERE id = ?;");
            statement.setLong(1,id_a);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean loginNurse(Nurse nurse){
        Long id_n = nurse.getId();
        String password = nurse.getPassword();
        Boolean flag = false;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Nurse\" WHERE id = ?");
            statement.setLong(1,id_n);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() && resultSet.getString("password").equals(password)){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Nurse getNurse(Nurse nurse){
        Nurse result = null;
        Long id_n = nurse.getId();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Nurse\" WHERE id=?;");
            statement.setLong(1,id_n);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                int experience = resultSet.getInt("experience");
                String address = resultSet.getString("address");
                int salary = resultSet.getInt("salary");
                int injections = resultSet.getInt("injections");
                int drugs = resultSet.getInt("drugs");
                int temperatures = resultSet.getInt("temperatures");
                int pressures = resultSet.getInt("pressures");

                result = new Nurse(id, password, name, surname, phone, experience, address, salary, injections, drugs, temperatures, pressures);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Nurse> getNurses(){
        ArrayList<Nurse> nurses = new ArrayList<Nurse>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Nurse\"");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                int experience = resultSet.getInt("experience");
                String address = resultSet.getString("address");
                int salary = resultSet.getInt("salary");
                int injections = resultSet.getInt("injections");
                int drugs = resultSet.getInt("drugs");
                int temperatures = resultSet.getInt("temperatures");
                int pressures = resultSet.getInt("pressures");

                nurses.add(new Nurse(id, password, name, surname, phone, experience, address, salary, injections, drugs, temperatures, pressures));
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return nurses;
    }

    public static void addNurse(Nurse nurse){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"Nurse\" (\n" +
                    "password, name, surname, phone, experience, address, salary, injections, drugs, temperatures, pressures) VALUES (\n" +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, nurse.getPassword());
            statement.setString(2, nurse.getName());
            statement.setString(3, nurse.getSurname());
            statement.setString(4, nurse.getPhone());
            statement.setInt(5, nurse.getExperience());
            statement.setString(6, nurse.getAddress());
            statement.setInt(7, nurse.getSalary());
            statement.setInt(8, nurse.getCountInjections());
            statement.setInt(9, nurse.getCountDrugs());
            statement.setInt(10, nurse.getCountTemperatures());
            statement.setInt(11, nurse.getCountPressures());

            int rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateNurse(Nurse nurse){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Nurse\" SET\n" +
                    "password = ?, name = ?, surname = ?, phone = ?, experience = ?, address = ?, salary = ?, injections = ?, drugs = ?, temperatures = ?, pressures = ? WHERE\n" +
                    "id = ?;");
            statement.setString(1, nurse.getPassword());
            statement.setString(2, nurse.getName());
            statement.setString(3, nurse.getSurname());
            statement.setString(4, nurse.getPhone());
            statement.setInt(5, nurse.getExperience());
            statement.setString(6, nurse.getAddress());
            statement.setInt(7, nurse.getSalary());
            statement.setInt(8, nurse.getCountInjections());
            statement.setInt(9, nurse.getCountDrugs());
            statement.setInt(10, nurse.getCountTemperatures());
            statement.setInt(11, nurse.getCountPressures());
            statement.setLong(12, nurse.getId());

            int rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean deleteNurse(Nurse nurse){
        Long id_n = nurse.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.\"Nurse\"\n" +
                    "WHERE id = ?;");
            statement.setLong(1,id_n);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean loginDoctor(Doctor doctor){
        Long id_d = doctor.getId();
        String password = doctor.getPassword();
        Boolean flag = false;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Doctor\" WHERE id = ?");
            statement.setLong(1,id_d);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() && resultSet.getString("password").equals(password)){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Doctor getDoctor(Doctor doctor){
        Doctor result = null;
        Long id_d = doctor.getId();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Doctor\" WHERE id=?;");
            statement.setLong(1,id_d);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                int experience = resultSet.getInt("experience");
                String address = resultSet.getString("address");
                int salary = resultSet.getInt("salary");
                int diagnoses = resultSet.getInt("diagnoses");
                int drugs = resultSet.getInt("drugs");
                int injections = resultSet.getInt("injections");
                int statuses = resultSet.getInt("statuses");

                result = new Doctor(id, password, name, surname, phone, experience, address, salary, diagnoses, drugs, injections, statuses);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Doctor> getDoctors(){
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Doctor\"");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                int experience = resultSet.getInt("experience");
                String address = resultSet.getString("address");
                int salary = resultSet.getInt("salary");
                int diagnoses = resultSet.getInt("diagnoses");
                int drugs = resultSet.getInt("drugs");
                int injections = resultSet.getInt("injections");
                int statuses = resultSet.getInt("statuses");

                doctors.add(new Doctor(id, password, name, surname, phone, experience, address, salary, diagnoses, drugs, injections, statuses));
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return doctors;
    }

    public static void addDoctor(Doctor doctor){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"Doctor\" (\n" +
                    "password, name, surname, phone, experience, address, salary, diagnoses, drugs, injections, statuses) VALUES (\n" +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, doctor.getPassword());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getSurname());
            statement.setString(4, doctor.getPhone());
            statement.setInt(5, doctor.getExperience());
            statement.setString(6, doctor.getAddress());
            statement.setInt(7, doctor.getSalary());
            statement.setInt(8, doctor.getDiagnosesCounter());
            statement.setInt(9, doctor.getDrugsCounter());
            statement.setInt(10, doctor.getInjectionsCounter());
            statement.setInt(11, doctor.getStatusCounter());

            int rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateDoctor(Doctor doctor){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Doctor\" SET\n" +
                    "password = ?, name = ?, surname = ?, phone = ?, experience = ?, address = ?, salary = ?, diagnoses = ?, drugs = ?, injections = ?, statuses = ? WHERE\n" +
                    "id = ?;");
            statement.setString(1, doctor.getPassword());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getSurname());
            statement.setString(4, doctor.getPhone());
            statement.setInt(5, doctor.getExperience());
            statement.setString(6, doctor.getAddress());
            statement.setInt(7, doctor.getSalary());
            statement.setInt(8, doctor.getDiagnosesCounter());
            statement.setInt(9, doctor.getDrugsCounter());
            statement.setInt(10, doctor.getInjectionsCounter());
            statement.setInt(11, doctor.getStatusCounter());
            statement.setLong(12, doctor.getId());

            int rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean deleteDoctor(Doctor doctor){
        Long id_d = doctor.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.\"Doctor\"\n" +
                    "WHERE id = ?;");
            statement.setLong(1,id_d);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Patient getPatient(Patient patient){
        Patient result = null;
        Long id_p = patient.getId();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Patient\" WHERE id=?;");
            statement.setLong(1,id_p);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int wardNumber = resultSet.getInt("wardnumber");
                String drug = resultSet.getString("drug");
                String injection = resultSet.getString("injection");
                String diagnosis = resultSet.getString("diagnosis");
                int drugs = resultSet.getInt("drugs");
                int injections = resultSet.getInt("injections");
                String status = resultSet.getString("status");
                double temperature = resultSet.getDouble("temperature");
                String pressure = resultSet.getString("pressure");
                Long idd = resultSet.getLong("idd");
                Long idn = resultSet.getLong("idn");

                result = new Patient(id, name, surname, phone, address, wardNumber, drug, injection, diagnosis, drugs, injections, status, temperature, pressure, idd, idn);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Patient> getPatients(){
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Patient\"");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int wardNumber = resultSet.getInt("wardnumber");
                String drug = resultSet.getString("drug");
                String injection = resultSet.getString("injection");
                String diagnosis = resultSet.getString("diagnosis");
                int drugs = resultSet.getInt("drugs");
                int injections = resultSet.getInt("injections");
                String status = resultSet.getString("status");
                double temperature = resultSet.getDouble("temperature");
                String pressure = resultSet.getString("pressure");
                Long idd = resultSet.getLong("idd");
                Long idn = resultSet.getLong("idn");

                patients.add(new Patient(id, name, surname, phone, address, wardNumber, drug, injection, diagnosis, drugs, injections, status, temperature, pressure, idd, idn));
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return patients;
    }

    public static void addPatient(Patient patient){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"Patient\" (\n" +
                    "name, surname, phone, address, wardnumber, drug, injection, diagnosis, drugs, injections, status, temperature, pressure, idd, idn) VALUES (\n" +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getSurname());
            statement.setString(3, patient.getPhone());
            statement.setString(4, patient.getAddress());
            statement.setInt(5, patient.getWardNumber());
            statement.setString(6, patient.getDrug());
            statement.setString(7, patient.getInjection());
            statement.setString(8, patient.getDiagnosis());
            statement.setInt(9, patient.getCountOfDrugs());
            statement.setInt(10, patient.getCountOfInjections());
            statement.setString(11, patient.getStatus());
            statement.setDouble(12, patient.getLastTemperature());
            statement.setString(13, patient.getLastPressure());
            statement.setLong(14, patient.getIdOfDoctor());
            statement.setLong(15, patient.getIdOfNurse());

            int rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatePatient(Patient patient){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "name = ?, surname = ?, phone = ?, address = ?, wardnumber = ?, drug = ?, injection = ?, diagnosis = ?, drugs = ?, injections = ?, status = ?, temperature = ?, pressure = ?, idd = ?, idn = ? WHERE\n" +
                    "id = ?;");
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getSurname());
            statement.setString(3, patient.getPhone());
            statement.setString(4, patient.getAddress());
            statement.setInt(5, patient.getWardNumber());
            statement.setString(6, patient.getDrug());
            statement.setString(7, patient.getInjection());
            statement.setString(8, patient.getDiagnosis());
            statement.setInt(9, patient.getCountOfDrugs());
            statement.setInt(10, patient.getCountOfInjections());
            statement.setString(11, patient.getStatus());
            statement.setDouble(12, patient.getLastTemperature());
            statement.setString(13, patient.getLastPressure());
            statement.setLong(14, patient.getIdOfDoctor());
            statement.setLong(15, patient.getIdOfNurse());
            statement.setLong(16, patient.getId());

            int rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean deletePatient(Patient patient){
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.\"Patient\"\n" +
                    "WHERE id = ?;");
            statement.setLong(1,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean giveTheInjection(Nurse nurse, Patient patient){
        Long id_n = nurse.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "injections = injections+1 WHERE\n" +
                    "id = ?;");
            statement.setLong(1,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void incrementInjection(Nurse nurse){
        Long id_n = nurse.getId();
        int rows=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.\"Nurse\" SET\n" +
                    "injections = injections+1 WHERE\n" +
                    "id = ?;");
            preparedStatement.setLong(1,id_n);
            rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean giveTheDrug(Nurse nurse, Patient patient){
        Long id_n = nurse.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "drugs = drugs+1 WHERE\n" +
                    "id = ?;");
            statement.setLong(1,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void incrementDrug(Nurse nurse){
        Long id_n = nurse.getId();
        int rows=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.\"Nurse\" SET\n" +
                    "drugs = drugs+1 WHERE\n" +
                    "id = ?;");
            preparedStatement.setLong(1,id_n);
            rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean measureTheTemperature(Nurse nurse, Patient patient){
        Long id_n = nurse.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "temperature = ? WHERE\n" +
                    "id = ?;");
            statement.setDouble(1, patient.getLastTemperature());
            statement.setLong(2,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void incrementTemperature(Nurse nurse){
        Long id_n = nurse.getId();
        int rows=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.\"Nurse\" SET\n" +
                    "temperatures = temperatures+1 WHERE\n" +
                    "id = ?;");
            preparedStatement.setLong(1,id_n);
            rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean measureThePressure(Nurse nurse, Patient patient){
        Long id_n = nurse.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "pressure = ? WHERE\n" +
                    "id = ?;");
            statement.setString(1, patient.getLastPressure());
            statement.setLong(2,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void incrementPressure(Nurse nurse){
        Long id_n = nurse.getId();
        int rows=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.\"Nurse\" SET\n" +
                    "pressures = pressures+1 WHERE\n" +
                    "id = ?;");
            preparedStatement.setLong(1,id_n);
            rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean makeNursePatient(Nurse nurse, Patient patient) {
        Long id_n = nurse.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "idn = ? WHERE\n" +
                    "id = ?;");
            statement.setLong(1, id_n);
            statement.setLong(2,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean prescribeTheInjection(Doctor doctor, Patient patient){
        Long id_d = doctor.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "injection = ? WHERE\n" +
                    "id = ?;");
            statement.setString(1, patient.getInjection());
            statement.setLong(2,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void incrementInjectionDoctor(Doctor doctor){
        Long id_d = doctor.getId();
        int rows=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.\"Doctor\" SET\n" +
                    "injections = injections+1 WHERE\n" +
                    "id = ?;");
            preparedStatement.setLong(1,id_d);
            rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean prescribeTheDrug(Doctor doctor, Patient patient){
        Long id_d = doctor.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "drugs = ? WHERE\n" +
                    "id = ?;");
            statement.setString(1, patient.getDrug());
            statement.setLong(2,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void incrementDrugDoctor(Doctor doctor){
        Long id_d = doctor.getId();
        int rows=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.\"Doctor\" SET\n" +
                    "drugs = drugs+1 WHERE\n" +
                    "id = ?;");
            preparedStatement.setLong(1,id_d);
            rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean makeTheDiagnosis(Doctor doctor, Patient patient){
        Long id_d = doctor.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "diagnosis = ? WHERE\n" +
                    "id = ?;");
            statement.setString(1, patient.getDiagnosis());
            statement.setLong(2,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void incrementDiagnosisDoctor(Doctor doctor){
        Long id_d = doctor.getId();
        int rows=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.\"Doctor\" SET\n" +
                    "diagnoses = diagnoses+1 WHERE\n" +
                    "id = ?;");
            preparedStatement.setLong(1,id_d);
            rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean assignTheStatus(Doctor doctor, Patient patient){
        Long id_d = doctor.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "status = ? WHERE\n" +
                    "id = ?;");
            statement.setString(1, patient.getStatus());
            statement.setLong(2,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void incrementStatusDoctor(Doctor doctor){
        Long id_d = doctor.getId();
        int rows=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.\"Doctor\" SET\n" +
                    "statuses = statuses+1 WHERE\n" +
                    "id = ?;");
            preparedStatement.setLong(1,id_d);
            rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean makeDoctorPatient(Doctor doctor, Patient patient) {
        Long id_d = doctor.getId();
        Long id_p = patient.getId();
        Boolean flag = false;
        int rows=0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Patient\" SET\n" +
                    "idd = ? WHERE\n" +
                    "id = ?;");
            statement.setLong(1, id_d);
            statement.setLong(2,id_p);

            rows = statement.executeUpdate();
            if (rows!=0){
                flag = true;
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
