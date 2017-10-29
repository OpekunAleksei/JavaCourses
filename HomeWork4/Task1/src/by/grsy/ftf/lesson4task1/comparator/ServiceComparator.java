/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.comparator;
import by.grsy.ftf.lesson4task1.entity.Service;
import java.util.Comparator;

public class ServiceComparator {

    private Comparator<Service> serviceByPriceComparator = new Comparator<Service>() {
        @Override
        public int compare(Service service, Service service1) {
            int serviceByPrice = 0;
            if (service != null) {
                serviceByPrice = service.getPrice().compareTo(service1.getPrice());
            }
            return serviceByPrice;

        }
    };
    private Comparator<Service> serviceByCategoryComparator = new Comparator<Service>() {
        @Override
        public int compare(Service service, Service service1) {
            int category = 0;
            if (service != null) {
                category = service.getCategory().compareTo(service1.getCategory());
            }
            return category;

        }
    };

    public Comparator<Service> getServiceByPriceComparator() {
        return serviceByPriceComparator;
    }

    public Comparator<Service> getServiceByCategoryComparator() {
        return serviceByCategoryComparator;
    }
}
