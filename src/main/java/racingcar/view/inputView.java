package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
public class inputView {
    private static final String REQUIRE_RACINGCAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String requireRacingCarName() {
        System.out.println(REQUIRE_RACINGCAR_NAME);
        return Console.readLine();
    }
}
