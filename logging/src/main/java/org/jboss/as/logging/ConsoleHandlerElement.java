/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.logging;

import org.jboss.staxmapper.XMLExtendedStreamWriter;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

public final class ConsoleHandlerElement extends AbstractHandlerElement<ConsoleHandlerElement> {

    private static final long serialVersionUID = 364161316534614911L;

    private Target target;

    private static final QName ELEMENT_NAME = new QName(Namespace.CURRENT.getUriString(), Element.CONSOLE_HANDLER.getLocalName());

    public ConsoleHandlerElement(final String name) {
        super(name, ELEMENT_NAME);
        target = Target.SYSTEM_OUT;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(final Target target) {
        this.target = target;
    }

    @Override
    protected Class<ConsoleHandlerElement> getElementClass() {
        return ConsoleHandlerElement.class;
    }

    @Override
    protected void writeElements(final XMLExtendedStreamWriter streamWriter) throws XMLStreamException {
        streamWriter.writeEmptyElement(Element.TARGET.getLocalName());
        streamWriter.writeAttribute(Attribute.NAME.getLocalName(), target.toString());
        super.writeElements(streamWriter);
    }

    @Override
    ConsoleHandlerAdd createAdd(final String name) {
        final ConsoleHandlerAdd add = new ConsoleHandlerAdd(name);
        add.setTarget(target);
        return add;
    }
}
