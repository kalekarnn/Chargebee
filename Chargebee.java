public class Chargebee {


// 1. X power N, with best complexity possible and dont use math.pow()   --->   X^N

// 2. In Chessboard, only two kings places randomly at any position.
//    Min distance for k1 to reach k2.
//    Example : k1(1,1) and k2(4,4)  = 3 Steps (1,1) -> (2,2) -> (3,3) -> (4,4)

    public static void main(String[] args) {
        Chargebee code = new Chargebee();
        //System.out.println(code.customPow(-4, 3));
        //System.out.println(code.optPow(2, 3));
        //System.out.println(code.optPowR(2, 3));
        System.out.println(code.optPowM(2, 3));
        code.getSteps(4, 1, 7, 7);
    }


    float customPow(int X, int N) {

        float result = 1;
        boolean negtive = false;

        if (N < 0) {
            N *= -1;
            negtive = true;
        }

        for (int i = 0; i < N; i++) {
            result *= X;
        }

        return negtive ? (float) (1 / result) : result;
    }


    float optPowR(int X, int N) {

        if (N == 0) {
            return 1;
        }

        return X * optPowR(X, N - 1);
    }


    float optPowM(int X, int N) {

        if (N == 0) {
            return 1;
        }

        if (N % 2 == 0) {
            return optPowM(X, N / 2) * optPowM(X, N / 2);
        } else {
            return X * optPowM(X, (N - 1) / 2) * optPowM(X, (N - 1) / 2);
        }
    }



    void getSteps(int x1, int y1, int x2, int y2) {

        System.out.println(x1 + " , " + y1);

        String result = getNextPosition(x1, y1, x2, y2);


        while (true) {
            String[] coordinates = result.split(" ");
            System.out.println(coordinates[0] + " , " + coordinates[1]);
            if (Integer.parseInt(coordinates[0]) == x2 && Integer.parseInt(coordinates[1]) == y2) {
                break;
            } else {
                result = getNextPosition(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), x2, y2);
            }
        }
    }


    String getNextPosition(int x1, int y1, int x2, int y2) {

        int result = 0;
        int HEIGHT = 8, WIDTH = 8;
        int min = 99999;
        int dist = 0;

        int nextX = x1, nextY = y1;

        if (x1 + 1 < WIDTH && y1 + 1 < HEIGHT) {
            dist = (x2 - (x1 + 1)) * (x2 - (x1 + 1)) + (y2 - (y1 + 1)) * (y2 - (y1 + 1));
            if (dist < min) {
                min = dist;
                nextX = x1 + 1;
                nextY = y1 + 1;
            }
        }

        if (x1 - 1 > 0 && y1 - 1 > 0) {
            dist = (x2 - (x1 - 1)) * (x2 - (x1 - 1)) + (y2 - (y1 - 1)) * (y2 - (y1 - 1));
            if (dist < min) {
                min = dist;
                nextX = x1 - 1;
                nextY = y1 - 1;
            }
        }

        if (x1 - 1 > 0 && y1 + 1 < HEIGHT) {
            dist = (x2 - (x1 - 1)) * (x2 - (x1 - 1)) + (y2 - (y1 + 1)) * (y2 - (y1 + 1));
            if (dist < min) {
                min = dist;
                nextX = x1 - 1;
                nextY = y1 + 1;
            }
        }

        if (x1 + 1 < WIDTH && y1 - 1 > 0) {
            dist = (x2 - (x1 + 1)) * (x2 - (x1 + 1)) + (y2 - (y1 - 1)) * (y2 - (y1 - 1));
            if (dist < min) {
                min = dist;
                nextX = x1 + 1;
                nextY = y1 - 1;
            }
        }

        if (x1 - 1 > 0) {
            dist = (x2 - (x1 - 1)) * (x2 - (x1 - 1)) + (y2 - y1) * (y2 - y1);
            if (dist < min) {
                min = dist;
                nextX = x1 - 1;
                nextY = y1;
            }
        }

        if (x1 + 1 < WIDTH) {
            dist = (x2 - (x1 + 1)) * (x2 - (x1 + 1)) + (y2 - y1) * (y2 - y1);
            if (dist < min) {
                min = dist;
                nextX = x1 + 1;
                nextY = y1;
            }
        }

        if (y1 + 1 < HEIGHT) {
            dist = (x2 - x1) * (x2 - x1) + (y2 - (y1 + 1)) * (y2 - (y1 + 1));
            if (dist < min) {
                min = dist;
                nextX = x1;
                nextY = y1 + 1;
            }
        }

        if (y1 - 1 > 0) {
            dist = (x2 - x1) * (x2 - x1) + (y2 - (y1 - 1)) * (y2 - (y1 - 1));
            if (dist < min) {
                min = dist;
                nextX = x1;
                nextY = y1 - 1;
            }
        }

        return nextX + " " + nextY;
    }
}
