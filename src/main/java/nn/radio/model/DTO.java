package nn.radio.model;

import java.io.Serializable;

public class DTO implements Serializable {

    DTO(float a) {
        this.A = a;
    }

    float A;
    int keyCode;
    float deltaX;
    float deltaY;

}
