package com.alexanderpopov.car.nameplate.resources;

import com.alexanderpopov.car.nameplate.R;

import java.util.ArrayList;

public class CarResource {

    private int mCarNameText;
    private int mCarLogoImage;
    private int mCarVinSchemeImage;
    private int mCarSchemeInfoText;
    private int mCarVinImage;
    private int mCarVinplateImage;
    private int mCarUrlColor;

    public CarResource(){

    }

    private CarResource(int carLogoImage, int carNameText,
                        int carVinSchemeImage, int carSchemeInfoText, int carVinImage, int carColor) {
        mCarNameText = carNameText;
        mCarLogoImage = carLogoImage;
        mCarVinSchemeImage = carVinSchemeImage;
        mCarSchemeInfoText = carSchemeInfoText;
        mCarVinImage = carVinImage;
        mCarUrlColor = carColor;
    }

    private CarResource(int carLogoImage, int carNameText,
                        int carVinSchemeImage, int carSchemeInfoText, int carVinImage, int carVinImage2, int carColor) {
        mCarLogoImage = carLogoImage;
        mCarNameText = carNameText;
        mCarVinSchemeImage = carVinSchemeImage;
        mCarSchemeInfoText = carSchemeInfoText;
        mCarVinImage = carVinImage;
        mCarVinplateImage = carVinImage2;
        mCarUrlColor = carColor;
    }

    public int getCarLabel() {
        return mCarLogoImage;
    }

    public int getCarName() {
        return mCarNameText;
    }

    public int getCarVinSchemeImage() {
        return mCarVinSchemeImage;
    }

    public int getCarSchemeInfoTex() {
        return mCarSchemeInfoText;
    }

    public int getCarVinImage() {
        return mCarVinImage;
    }

    public int getCarVinImage2() {
        return mCarVinplateImage;
    }

    public int getCarUrlColor() {
        return mCarUrlColor;
    }

    public ArrayList<CarResource> carLabelAndName() {

        ArrayList<CarResource> mArrayData = new ArrayList<>();

        mArrayData.add(new CarResource(R.drawable.car_model_audi, R.string.AUDI,
                R.drawable.scheme_audi_vw, R.string.audi_scheme,
                R.drawable.vin_audi, R.drawable.vinplate_audi, R.string.audi_url));
        mArrayData.add(new CarResource(R.drawable.car_model_bmw, R.string.BMW,
                R.drawable.scheme_bmw, R.string.bmw_scheme,
                R.drawable.vin_bmw, R.drawable.vinplate_bmw, R.string.bmw_url));
        mArrayData.add(new CarResource(R.drawable.car_model_chevrolet, R.string.CHEVROLET,
                R.drawable.scheme_chevrolet, R.string.chevrolet_scheme,
                R.drawable.vin_chevrolet, R.drawable.vinplate_chevrolet, R.string.chevrolet_url));
        mArrayData.add(new CarResource(R.drawable.car_model_citroen, R.string.CITROEN,
                R.drawable.scheme_citroen, R.string.citroen_scheme,
                R.drawable.vin_citroen, R.drawable.vinplate_citroen, 0));
        mArrayData.add(new CarResource(R.drawable.car_model_daewoo, R.string.DAEWOO,
                R.drawable.scheme_daewoo, R.string.daewoo_scheme,
                R.drawable.vin_daewoo, R.drawable.vinplate_daewoo, R.string.daewoo_url));
        mArrayData.add(new CarResource(R.drawable.car_model_fiat, R.string.FIAT,
                R.drawable.scheme_fiat, R.string.fiat_scheme,
                R.drawable.vin_fiat, R.drawable.vinplate_fiat, R.string.fiat_url));
        mArrayData.add(new CarResource(R.drawable.car_model_ford, R.string.FORD,
                R.drawable.scheme_ford, R.string.ford_scheme,
                R.drawable.vin_ford, R.drawable.vinplate_ford, R.string.ford_url));
        mArrayData.add(new CarResource(R.drawable.car_model_honda, R.string.honda,
                R.drawable.scheme_honda, R.string.honda_scheme,
                R.drawable.vin_honda, R.drawable.vinplate_honda, R.string.honda_url));
        mArrayData.add(new CarResource(R.drawable.car_model_hyundai, R.string.HYUNDAI,
                R.drawable.scheme_hyundai, R.string.hyundai_scheme,
                R.drawable.vin_hyundai, R.drawable.vinplate_hyundai, R.string.hyunday_url));
        mArrayData.add(new CarResource(R.drawable.car_model_jaguar, R.string.JAGUAR,
                R.drawable.scheme_jaguar, R.string.jaguar_scheme,
                R.drawable.vin_jaguar, R.drawable.vinplate_jaguar, R.string.jaguar_url));
        mArrayData.add(new CarResource(R.drawable.car_model_infiniti, R.string.INFINITY,
                R.drawable.scheme_infiniti, R.string.infinity_scheme,
                R.drawable.vin_infiniti, R.drawable.vinplate_infiniti, R.string.infinity_url));
        mArrayData.add(new CarResource(R.drawable.car_model_kia, R.string.KIA,
                R.drawable.scheme_kia, R.string.kia_scheme,
                R.drawable.vin_kia, R.drawable.scheme_kia, R.string.kia_url));
        mArrayData.add(new CarResource(R.drawable.car_model_land_rover, R.string.LAND_ROVER,
                R.drawable.scheme_landrover, R.string.landrover_scheme,
                R.drawable.vin_landrover, R.drawable.vinplate_landrover));
        mArrayData.add(new CarResource(R.drawable.car_model_lexus, R.string.LEXUS,
                R.drawable.scheme_lexus, R.string.lexus_scheme,
                R.drawable.vin_lexus, R.drawable.vinplate_lexus, R.string.lexus_url));
        mArrayData.add(new CarResource(R.drawable.car_model_mazda, R.string.MAZDA,
                R.drawable.scheme_mazda, R.string.mazda_scheme,
                R.drawable.vinplate_mazda, R.string.mazda_url));
        mArrayData.add(new CarResource(R.drawable.car_model_mitsubishi, R.string.MITSUBISHI,
                R.drawable.scheme_mitsubishi, R.string.mitsubishi_scheme,
                R.drawable.vinplate_mitsubishi, R.string.mitsubishi_url));
        mArrayData.add(new CarResource(R.drawable.car_model_nissan, R.string.NISSAN,
                R.drawable.scheme_nissan, R.string.nissan_scheme,
                R.drawable.vin_nissan, R.drawable.vinplate_nissan, R.string.nissan_url));
        mArrayData.add(new CarResource(R.drawable.car_model_opel, R.string.OPEL,
                R.drawable.scheme_opel, R.string.opel_scheme,
                R.drawable.vin_opel, R.drawable.vinplate_opel));
        mArrayData.add(new CarResource(R.drawable.car_model_peugeot, R.string.PEUGEOT,
                R.drawable.scheme_peugeot, R.string.peugeot_scheme,
                R.drawable.vin_peugeot, R.drawable.vinplate_peugeot, R.string.peugeot_url));
        mArrayData.add(new CarResource(R.drawable.car_model_renault, R.string.RENAULT,
                R.drawable.scheme_renault, R.string.renault_scheme,
                R.drawable.vin_renault, R.drawable.vinplate_renault, R.string.renault_url));
        mArrayData.add(new CarResource(R.drawable.car_model_skoda, R.string.SKODA,
                R.drawable.scheme_skoda, R.string.skoda_scheme,
                R.drawable.vin_skoda, R.drawable.vinplate_skoda));
        mArrayData.add(new CarResource(R.drawable.car_model_subaru, R.string.SUBARU,
                R.drawable.scheme_subaru, R.string.subaru_scheme,
                R.drawable.vin_subaru, R.drawable.vinplate_subaru, R.string.subaru_url));
        mArrayData.add(new CarResource(R.drawable.car_model_toyota, R.string.TOYOTA,
                R.drawable.scheme_toyota, R.string.toyota_scheme,
                R.drawable.vin_toyota, R.drawable.car_model_toyota, R.string.toyota_url)); // no vinplate
        mArrayData.add(new CarResource(R.drawable.car_model_volvo, R.string.VOLVO,
                R.drawable.scheme_volvo, R.string.volvo_scheme,
                R.drawable.vin_volvo, R.drawable.scheme_volvo));
        mArrayData.add(new CarResource(R.drawable.car_model_volkswagen, R.string.VW,
                R.drawable.scheme_audi_vw, R.string.vw_scheme,
                R.drawable.vin_volkswagen, R.drawable.vin_volkswagen, R.string.vw_url));
        mArrayData.add(new CarResource(R.drawable.car_model_mercedes, R.string.MERCEDES,
                R.drawable.scheme_mercedes, R.string.mercedes_scheme,
                R.drawable.vin_mercedes, R.drawable.vinplate_mercedes));

        return mArrayData;
    }
}
