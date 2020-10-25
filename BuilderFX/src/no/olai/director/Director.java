package no.olai.director;

import no.olai.builder.Builder;

public class Director {

    private final int w = 90;
    private final int h = 20;


    public void createBoxSmall(Builder builder) {
        builder.setLabelAndSize("SmallLabel", "consolas", 15);
        builder.setButtonAndSize("SmallButton", w, h);
    }

    public void createMediumBox(Builder builder) {
        builder.setLabelAndSize("MediumLabel","Tahoma", 20);
        builder.setButtonAndSize("MediumButton", w * 2, h * 2);
    }

    public void createLargeBox(Builder builder) {
        builder.setLabelAndSize("LargeLabel", "Verdana", 25);
        builder.setButtonAndSize("LargeButton",w * 3 , h * 3);
    }

}
