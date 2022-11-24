package tv.example;

public class OurService {

    MockedService mockedService;

    public OurService(MockedService mockedService) {
        this.mockedService = mockedService;
    }

    public int perform(int i, int j) {
        return mockedService.add(i, j);
    }
}
