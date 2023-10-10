1. 함수 - 동사로 시작 ex) updateData, getData…
2. 변수 - 명사로 시작 ex) number, count, index ( 예외 : sortedArray 같은거 )
3. 클래스 - PascalCase로
4. static final 상수는 대문자 스네이크 케이스로 ex)  private static final int MAX_VALUE = 30;
5. Regex 사용시 주석으로 설명해주세요  ex) (.+[A-Za-z]+)$ // file의 확장자를 가지고 오는 정규식
6. Lombok getter 사용합시다 / setter는 최대한 사용을 피하자 (data는 절대 금지)
7. 값 바꿀거면 setter로 바꿔주세요
8. 로직이 너무 길어지면 나눠주세요. (케바케)
9. 클래스 접근 제어자는 private protected default public 순서로 해주세요, static은 제일 위로 

Ex) 

Class A() {
    private static int a = 30;

    public static int b = 10;

    prvate int c = 10;
    prvate int d = 10;
}