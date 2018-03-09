package controller;

import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());

        uiModule.addEvent(EventName.COPY, () -> applicationState.commandEvent(EventName.COPY));
        uiModule.addEvent(EventName.PASTE, () -> applicationState.commandEvent(EventName.PASTE));
        uiModule.addEvent(EventName.UNDO, () -> applicationState.commandEvent(EventName.UNDO));
        uiModule.addEvent(EventName.REDO, () -> applicationState.commandEvent(EventName.REDO));
        uiModule.addEvent(EventName.DELETE, () -> applicationState.commandEvent(EventName.DELETE));
    }
}
