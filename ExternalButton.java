import enums.ElevatorDirection;

public class ExternalButton {



    private final ExternalDispatcher externalDispatcher;

    public ExternalButton(ExternalDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    }

    public void pressButton(int floor, ElevatorDirection direction)
    {
        externalDispatcher.submitExternalRequest(floor,direction);
    }
}
