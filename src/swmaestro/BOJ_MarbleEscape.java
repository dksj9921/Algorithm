package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_MarbleEscape {
    static int N, M;
    static char[][] map;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static boolean isFinished = false;
    static boolean isBlueFinished = false;
    static Marble redMarble, blueMarble;
    static Hole hole;
    static boolean isRedBack = false;
    static boolean isBlueBack = false;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char tempCharArr[] = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = tempCharArr[j];
                if (map[i][j] == 'R') {
                    redMarble = new Marble(new Point(j, i));
                } else if (map[i][j] == 'B') {
                    blueMarble = new Marble(new Point(j, i));
                } else if (map[i][j] == 'O') {
                    hole = new Hole(new Point(j, i));
                }
            }
        }

        GetDirection(0, 4);

        System.out.println(0);
    }

    static void GetDirection(int count, int lastDirection) {

        if (count == 0) {
            return;
        }

        char tempMap[][] = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        int tempRedPointX = redMarble.marbleLocation.x;
        int tempRedPointY = redMarble.marbleLocation.y;
        int tempBluePointX = blueMarble.marbleLocation.x;
        int tempBluePointY = blueMarble.marbleLocation.y;

        for (int i = 0; i < 4; i++) {
            if (lastDirection == 0 || lastDirection == 1) {
                if (i == 0 || i == 1) {
                    continue;
                }
            } else if (lastDirection == 2 || lastDirection == 3) {
                if (i == 2 || i == 3) {
                    continue;
                }
            }
            map = tempMap;
            redMarble.marbleLocation.x = tempRedPointX;
            redMarble.marbleLocation.y = tempRedPointY;
            blueMarble.marbleLocation.x = tempBluePointX;
            blueMarble.marbleLocation.y = tempBluePointY;
            boolean answer = MoveDirection(i);
            if (!answer) {
                GetDirection(count + 1, i);
            }else{
                return;
            }
        }
    }

    static boolean MoveDirection(int index) {
        int tempRedPointX = redMarble.marbleLocation.x;
        int tempRedPointY = redMarble.marbleLocation.y;
        int tempBluePointX = blueMarble.marbleLocation.x;
        int tempBluePointY = blueMarble.marbleLocation.y;
        isFinished = false;
        isBlueFinished = false;
        isRedBack = false;
        isBlueBack = false;

        RedMarbleMove(index);
        BlueMableMove(index);

        map[tempBluePointY][tempBluePointX] = '.';
        map[tempRedPointY][tempRedPointX] = '.';

        if (!isFinished && !isBlueFinished) {
            if (isBlueBack) {
                map[blueMarble.marbleLocation.y - dy[index]][blueMarble.marbleLocation.x - dx[index]] = 'B';
                map[redMarble.marbleLocation.y][redMarble.marbleLocation.x] = 'R';
            } else if (isRedBack) {
                map[redMarble.marbleLocation.y - dy[index]][redMarble.marbleLocation.x - dx[index]] = 'R';
                map[blueMarble.marbleLocation.y][blueMarble.marbleLocation.x] = 'B';
            } else {
                map[blueMarble.marbleLocation.y][blueMarble.marbleLocation.x] = 'B';
                map[redMarble.marbleLocation.y][redMarble.marbleLocation.x] = 'R';
            }
            return false;
        } else if (isFinished && !isBlueFinished) {
            System.out.println(1);
            System.exit(0);

        } else if (isBlueFinished) {
            return true;
        }

        return false;
    }

    static void RedMarbleMove(int index) {
        Point location = redMarble.marbleLocation;

        int x = location.x + dx[index];
        int y = location.y + dy[index];

        if (x >= 0 && x < M && y >= 0 && y < N) {
            if (map[y][x] == '#') {
                return;
            }
            if (map[y][x] != '#') {
                redMarble.marbleLocation.x = x;
                redMarble.marbleLocation.y = y;
                if (map[y][x] == 'B') {
                    isRedBack = true;
                }
                if (hole.holeLocation.x == x && hole.holeLocation.y == y) {
                    isFinished = true;
                    return;
                }
                RedMarbleMove(index);
            }
        }
    }

    static void BlueMableMove(int index) {
        Point location = blueMarble.marbleLocation;

        int x = location.x + dx[index];
        int y = location.y + dy[index];

        if (x >= 0 && x < M && y >= 0 && y < N) {
            if (map[y][x] == '#') {
                return;
            }
            if (map[y][x] != '#') {
                blueMarble.marbleLocation.x = x;
                blueMarble.marbleLocation.y = y;

                if (map[y][x] == 'R') {
                    isBlueBack = true;
                }
                if (hole.holeLocation.x == x && hole.holeLocation.y == y) {
                    isBlueFinished = true;
                    return;
                }
                BlueMableMove(index);
            }
        }
    }

    static class Marble{
        Point marbleLocation;

        Marble(Point marbleLocation) {
            this.marbleLocation = marbleLocation;
        }
    }

    static class Hole {
        Point holeLocation;

        Hole(Point holeLocation) {
            this.holeLocation = holeLocation;
        }
    }
}
