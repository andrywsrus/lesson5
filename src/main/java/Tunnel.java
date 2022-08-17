public class Tunnel extends Stage {
    Tunnel() {
        this.length = 80;
        this.description = "������� " + length + " ������";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " ��������� � �����(����): " + description);
                MainClass.tunnel.acquire();
                System.out.println(c.getName() + " ����� ����: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                MainClass.tunnel.release();
                System.out.println(c.getName() + " �������� ����: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}