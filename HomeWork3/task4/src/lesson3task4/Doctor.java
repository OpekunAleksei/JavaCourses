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
public class Doctor extends Human{
    private int kolichestvoPatientov=0;


    public void setzapic() {
        this.kolichestvoPatientov = this.kolichestvoPatientov + 1;
    }
    public void setotpis() {
        this.kolichestvoPatientov = this.kolichestvoPatientov - 1 ;
    }

    public int getKolichestvoPatientov() {
        return kolichestvoPatientov;
    }

}
