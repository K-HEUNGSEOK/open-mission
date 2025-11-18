package change.lottoMission;

import change.lottoMission.lotto.LottoController;
import change.lottoMission.lotto.view.InputView;
import change.lottoMission.lotto.view.OutView;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LottoMissionApplication {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		InputView inputView = new InputView();
		OutView outView = new OutView();
		Scanner scanner = new Scanner(System.in);
		LottoController lottoController = new LottoController(inputView, outView,scanner);
		lottoController.execute();
	}

}
