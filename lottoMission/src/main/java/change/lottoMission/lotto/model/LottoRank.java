package change.lottoMission.lotto.model;

public enum LottoRank {
    FIRST(6, "2,000,000,000"),
    SECOND(5, "30,000,000"),
    THIRD(5, "1,500,000"),
    FOURTH(4, "50,000"),
    FIFTH(3, "5,000"),
    MISS(0, "0");

    private final int matchCount;
    private final String rewardMoney;


    LottoRank(int matchCount, String rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getRewardMoney() {
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
