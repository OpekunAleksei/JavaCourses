package com.senla.hotel.comparators;

import com.senla.hotel.entity.Service;
import java.util.Comparator;

public class ServiceComparator {

    private Comparator<Service> serviceByPriceComparator = (Service service, Service service1) -> {
        int serviceByPrice = 0;
        if (service != null) {
            serviceByPrice = service.getPrice().compareTo(service1.getPrice());
        }
        return serviceByPrice;
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
