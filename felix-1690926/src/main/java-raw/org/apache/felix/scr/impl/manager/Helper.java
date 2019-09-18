package org.apache.felix.scr.impl.manager;

import org.apache.felix.scr.impl.config.ComponentContainer;
import org.apache.felix.scr.impl.helper.ComponentMethods;
import org.apache.felix.scr.impl.manager.SingleComponentManager;

public class Helper<S> extends SingleComponentManager {

    public Helper ( ComponentContainer<S> container, ComponentMethods componentMethods ) {
        super(container, componentMethods);
        this.m_internalEnabled = true;
    }

    @Override
    boolean getServiceInternal() {
        return true;
    }

}