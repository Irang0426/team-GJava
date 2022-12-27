package lotto;

public class Strings {
    //패턴
    public static final String numPattern = "^[0-9]+$";
    public static final String lottoPattern = "^\\d+,\\d+,\\d+,\\d+,\\d+,\\d+$";

    //에러 메시지
    public static final String ERROR= "[ERROR] ";
    public static final String NOT_INT = ERROR + "숫자를 입력해야 합니다.";
    public static final String PURCHASE_RANGE_OVER = ERROR + "구매 금액은 1,000원 단위로만 입력할 수 있습니다.";
    public static final String LOTTO_RANGE_OVER = ERROR + "로또 번호는 1~45번까지 입력할 수 있습니다.";
    public static final String NOT_LOTTO_PATTERN = ERROR + "로또 번호는 1,2,3,4,5,6 과 같은 형태로 입력할 수 있습니다.";
    public static final String DUPLICATE_LOTTO_NUMS = ERROR + "로또 번호는 중복해서 입력할 수 없습니다.";
    public static final String BONUS_ALREADY_CONTAINED = ERROR + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    //시스템 메시지
    public static final String INPUT_MONEY ="구입금액을 입력해 주세요.\n";
    public static final String PURCHASE_NUM ="%d개를 구매했습니다.\n";
    public static final String SET_WINNINGNUMS ="당첨 번호를 입력해 주세요.";
    public static final String SET_BONUS ="보너스 번호를 입력해 주세요.";
    public static final String SHOW_WINNINGS ="당첨 통계\n"+
            "---\n"+
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n";
    public static final String SHOW_PROFIT ="총 수익률은 %.1f%%입니다.";

}