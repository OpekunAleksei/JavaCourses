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
reg.createpatients("Пётр Петров",12);
reg.createpatients("Семён Семёнов",13);
reg.createpatients("Анстасия Ёрш",15);
reg.createpatients("Валерия Поклин",17);
reg.createpatients("Норман Петигрю",20);
reg.createdoctors("Гарри Поттер");
reg.createdoctors("Том Рэдл");
reg.createdoctors("Альбус Дамблдор");
reg.createdoctors("Северус Снэйп");
reg.entry("Том Рэдл",15);
reg.entry("Том Рэдл",20);
reg.entry("Том Рэдл",17);

System.out.println("Количество пациентов записанных к Том Рэдл "+reg.NPacientZapicKDoctor("Том Рэдл"));
reg.describe("Том Рэдл",20);
System.out.println("Количество пациентов записанных к Том Рэдл "+reg.NPacientZapicKDoctor("Том Рэдл"));
System.out.println("Колличество Докторов "+reg.numberDoctors());
System.out.println("Колличество Пациентов "+reg.numberPatients());
    
    }
    
}
