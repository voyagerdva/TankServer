package nn.radio.model;

import java.awt.event.KeyEvent;

public class Calculate {

    float deltaA = 15.0F;
    float speed = 0.8F;

    public Calculate() {
    }

    public DTO calcCoordinateByKeyEventPressed(DTO dto) {
        if (dto.keyCode == KeyEvent.VK_LEFT) {
            dto.A = dto.A - deltaA;
            return dto;
        }

        if (dto.keyCode == KeyEvent.VK_RIGHT) {
            dto.A = dto.A + deltaA;
            return dto;
        }


        if (dto.keyCode == KeyEvent.VK_UP) {
            System.out.println("A = " + dto.A);
            if (dto.A > 0) {
                dto.deltaX = (float) (speed * Math.sin(Math.toRadians(Math.abs(dto.A))));
                dto.deltaY = (float) (-speed * Math.cos(Math.toRadians(Math.abs(dto.A))));
            }

            if (dto.A <= 0) {
                dto.deltaX = (float) (-speed * Math.sin(Math.toRadians(Math.abs(dto.A))));
                dto.deltaY = (float) (-speed * Math.cos(Math.toRadians(Math.abs(dto.A))));
            }
            return dto;
        }

        if (dto.keyCode == KeyEvent.VK_DOWN) {
            System.out.println("A = " + dto.A);

            if (dto.A > 0) {
                dto.deltaX = (float) (-speed * Math.sin(Math.toRadians(Math.abs(dto.A))));
                dto.deltaY = (float) (speed * Math.cos(Math.toRadians(Math.abs(dto.A))));
            }

            if (dto.A <= 0) {
                dto.deltaX = (float) (speed * Math.sin(Math.toRadians(Math.abs(dto.A))));
                dto.deltaY = (float) (speed * Math.cos(Math.toRadians(Math.abs(dto.A))));
            }
            return dto;
        }

        return null;
//        return 0;
    }

}
