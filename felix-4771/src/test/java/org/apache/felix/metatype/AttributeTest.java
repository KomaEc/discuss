/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.felix.metatype;

import junit.framework.TestCase;

import org.junit.Test;


/**
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public class AttributeTest extends TestCase
{

    /**
     * FELIX-4771 - attributes can be content-less.
     */
    @Test
    public void testAttributeWithoutContentOk() throws Exception
    {
        Attribute attr = new Attribute();

        assertNull(attr.getContent());

        // Null-values are ignored, so attribute remains empty...
        attr.addContent(null, false);

        assertNull(attr.getContent());
    }

    /**
     * FELIX-4771 - attributes can be content-less.
     */
    @Test
    public void testAttributeWithNullContentOk() throws Exception
    {
        Attribute attr = new Attribute();
        // Null-values are ignored, so attribute remains empty...
        attr.addContent(null, false);

        assertNull(attr.getContent());
    }

    public void testAttributeWithContentOk() throws Exception
    {
        Attribute attr = new Attribute();
        attr.addContent("foo", false /* split */);

        assertNotNull(attr.getContent());
    }
}
