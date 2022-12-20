package lotto;


public class Application {
    public static int BONUSNUMBER;
    public static Lotto WINNINGNUMBERS;
    public static CustomerLotto customerLotto = new CustomerLotto();

    public static void main(String[] args) {
        ServiceSetNumFix.run();
        Service_ShowLottos.run();
        Service_ShowResultLottos.run();
    }

}
/*
    CustomerLotto             로또를 여러개 저장, 금액도 저장

    Lotto                     1~45/ 6개숫자 /중복x

    Service                   인터페이스 만들고 run 추상 메서드로줘서 Service_~~~~.run 으로 묶자....?...

    Service_SetNum            당첨 숫자 설정(자동) / 고객의 로또 입력          잘못해석했다...
    Service_SetNumFix         money입력/고객의 로또 설정(자동)/ 당첨숫자 입력/보너스 입력
    Service_ShowLottos        발행한 로또 수량 및 번호 출력
    Service_ShowWinLottos     고객의 로또 당첨내역, 통계 수익률 출력

    Application               실행하고 싶은 service를 실행  , static변수들 선언

    String                    enum형으로 출력메세지 관리하기.

     */