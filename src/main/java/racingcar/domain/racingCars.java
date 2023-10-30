package racingcar.domain;

import racingcar.exception.InvalidRacingCarNameLengthException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class racingCars {
    private static int racingCarNumber;
    private static List<racingCar> racingCarList;

    public racingCars(String racingCarNameString) {
        String[] racingCarNameArray = validateRacingCarNameFormat(racingCarNameString);
        this.racingCarNumber = racingCarNameArray.length;
        System.out.println("racingCarNumber = " + racingCarNumber);
        this.racingCarList = convertRacingCarFormat(racingCarNameArray);
    }

    private List<racingCar> convertRacingCarFormat(String[] racingCarNameArray) {
        List<racingCar> playerRacingCarList = new ArrayList<>();
        for (String racingCarName : racingCarNameArray) {
            playerRacingCarList.add(new racingCar(racingCarName));
        }
        return playerRacingCarList;
    }


    private String[] validateRacingCarNameFormat(String racingCarNameString) {
        String[] racingCarNameArray = Arrays.stream(racingCarNameString.split(","))
                .map(String::strip)
                .toArray(String[]::new);

        boolean hasFiveOrMoreCharacters = Arrays.stream(racingCarNameArray)
                .anyMatch(name -> name.length() > 5);

        if (hasFiveOrMoreCharacters) {
            throw new InvalidRacingCarNameLengthException();
        }
        return racingCarNameArray;
    }
}
