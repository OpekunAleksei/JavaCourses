/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3task4;

/**
 *
 * @author Алексей
 */
public class Lesson3Task4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Registratura reg = new Registratura(); 
reg.createpatients("Пётр Петров");
reg.createpatients("Семён Семёнов");
reg.createpatients("Анстасия Ёрш");
reg.createpatients("Валерия Поклин");
reg.createpatients("Норман Петигрю");
reg.createdoctors("Гарри Поттер");
reg.createdoctors("Том Рэдл");
reg.createdoctors("Альбус Дамблдор");
reg.createdoctors("Северус Снэйп");
reg.zapic("Том Рэдл");
System.out.println("Количество пациентов записанных к Том Рэдл "+reg.NPacientZapicKDoctor("Том Рэдл"));
reg.otpis("Том Рэдл");
System.out.println("Количество пациентов записанных к Том Рэдл "+reg.NPacientZapicKDoctor("Том Рэдл"));
System.out.println("Колличество Докторов "+reg.kolichestvoDoctors());
System.out.println("Колличество Пациентов "+reg.kolichestvoPatients());
    
    }
    
}
