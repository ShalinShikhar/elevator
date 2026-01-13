import enums.ElevatorDirection;

import java.util.List;

public  class NearestElevatorStrategy implements ElevatorSelectionStrategy{
    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor, ElevatorDirection direction) {

        ElevatorController best=null;
        int minDistace=Integer.MAX_VALUE;

        //same direction and min distance

        for(ElevatorController controller : controllers)
        {
            int nextFloorStoppage=controller.elevatorCar.nextFloorStoppage;

            //good if same direction

            boolean isSameDirection=controller.elevatorCar.movingDirection==direction && ((direction==ElevatorDirection.UP && nextFloorStoppage<=requestFloor) || direction==ElevatorDirection.DOWN && nextFloor>=requestFloor);

            int dist=Math.abs(nextFloorStoppage-requestFloor);

            if(isSameDirection && dist<minDistace)
            {
                minDistace=dist;
                best=controller;
            }
        }
        // if not able to choose
        if(best==null)
        {
            for(ElevatorController controller : controllers)
            {
                if(controller.elevatorCar.movingDirection==ElevatorDirection.IDLE)
                {
                    best=controller;
                    break;
                }
            }
            //reached here no list is going in same direction and no lift is idle
            if(best==null)
            {
                best=controllers.get(0);
            }
        }
        return best;
    }
}
