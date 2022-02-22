package domain;

import java.util.List;

public class User {
    private final int money;
    private List<Lotto> lottos;

    public User(int money) {
        this.money = money;
    }

    public void buy() {
        lottos = LottoMachine.createLottos(money);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void matchWinningLotto(Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            int count = lotto.getMatchBallCount(winningLotto);
        }
    }
}
