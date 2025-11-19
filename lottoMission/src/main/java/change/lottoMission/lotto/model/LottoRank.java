package change.lottoMission.lotto.model;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private final int matchCount;
    private final int rewardMoney;


    LottoRank(int matchCount, int rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static LottoRank findRank(int count, boolean bonusMatch) {
        if (count == 5) {
            if (bonusMatch) {
                return SECOND;
            }
            return THIRD;
        }

        for (LottoRank value : LottoRank.values()) {
            if (value.matchCount == count) {
                return value;
            }
        }

        return MISS;
    }
}
