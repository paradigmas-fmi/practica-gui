package org.practicagui.View;

import javafx.scene.image.Image;

public class ButacaView {
    private final Image asientoDisponible = new Image(String.valueOf(getClass().getResource("/org/practicagui/images/empty-seat.png")));

    private final Image asientoOcupado = new Image(String.valueOf(getClass().getResource("/org/practicagui/images/occupied-seat.png")));

    public ButacaView() {}

    public Image getAsientoDisponible() {
        return asientoDisponible;
    }

    public Image getAsientoOcupado() {
        return asientoOcupado;
    }
}
