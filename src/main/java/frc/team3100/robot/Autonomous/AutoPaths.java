package frc.team3100.robot.Autonomous;

import frc.team3100.robot.Variables;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class AutoPaths {
    private Variables.startPosition left = Variables.startPosition.LEFT;
    private Variables.startPosition right = Variables.startPosition.RIGHT;
    private Variables.startPosition center = Variables.startPosition.CENTER;

    private Variables.target cargoFront = Variables.target.CARGOFRONT;
    private Variables.target cargoSide = Variables.target.CARGOSIDE;
    private Variables.target rocket = Variables.target.ROCKET;
    private Variables.target none = Variables.target.NONE;


    public AutoPaths() {
    }

    public Waypoint[] pointsFromStart(Variables.startPosition start, Variables.target target) {
        Waypoint[] points = null;

        if(start == left) {
            /** LEFT START */

            if(target == cargoSide) {
                /** CARGO SIDE FROM LEFT START */
                points = new Waypoint[]{
                        new Waypoint(40, 118, 0),
                        new Waypoint(100,118,0),
                        new Waypoint(234,60,0),
                        new Waypoint(280,100,Pathfinder.d2r(90))};

            } else if(target == cargoFront) {
                /** CARGO FRONT FROM LEFT START */
                points = new Waypoint[]{
                        new Waypoint(40, 118, 0),
                        new Waypoint(100,118,0),
                        new Waypoint(190,151,0)};

            } else if(target == rocket) {
                /** ROCKET FROM LEFT START */
                points = new Waypoint[]{
                        new Waypoint(40, 118, 0),
                        new Waypoint(100,118,0),
                        new Waypoint(180,36,Pathfinder.d2r(-30))};
            }


        } else if(start == right) {
            /** RIGHT START */

            if(target == cargoSide) {
                /** CARGO SIDE FROM RIGHT START */
                points = new Waypoint[]{
                        new Waypoint(40, 208, 0),
                        new Waypoint(100,208,0),
                        new Waypoint(234,260,0),
                        new Waypoint(280,220,Pathfinder.d2r(-90))};

            } else if(target == cargoFront) {
                /** CARGO FRONT FROM RIGHT START */
                points = new Waypoint[]{
                        new Waypoint(40, 208, 0),
                        new Waypoint(100,208,0),
                        new Waypoint(190,174,0)};

            } else if(target == rocket) {
                /** ROCKET FROM RIGHT START */
                points = new Waypoint[]{
                        new Waypoint(40, 208, 0),
                        new Waypoint(100,208,0),
                        new Waypoint(180,288,Pathfinder.d2r(30))};
            }


        } else {
            /** CENTER START */

            if(target == cargoFront) {
                /** CARGO FRONT FROM LEFT START */
                points = new Waypoint[]{
                        new Waypoint(70, 163, 0),
                        new Waypoint(190,151,0)};
            }
        }

        if(points == null) {
            System.out.println("Invalid Start Parameters");
            return null;
        } else {
            return points;
        }
    }
}
