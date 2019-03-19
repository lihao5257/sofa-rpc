/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.rpc.bootstrap;

import com.alipay.sofa.rpc.config.ProviderConfig;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href=mailto:leizhiyuan@gmail.com>leizhiyuan</a>
 */
public class DefaultProviderBootstrapTest {

    @Test
    public void includeListTest() {

        ProviderConfig providerConfig = new ProviderConfig();
        DefaultProviderBootstrap defaultProviderBootstra = new DefaultProviderBootstrap(providerConfig);
        boolean result = defaultProviderBootstra.inList("hello1", "hello2", "hello1");
        Assert.assertTrue(result);
    }

    @Test
    public void includeMultiListTest() {

        ProviderConfig providerConfig = new ProviderConfig();
        DefaultProviderBootstrap defaultProviderBootstra = new DefaultProviderBootstrap(providerConfig);
        boolean result = defaultProviderBootstra.inList("hello1,hello3", "hello1,hello2,hello4", "hello1");
        Assert.assertTrue(!result);
    }

    @Test
    public void excludeListTest() {

        ProviderConfig providerConfig = new ProviderConfig();
        DefaultProviderBootstrap defaultProviderBootstra = new DefaultProviderBootstrap(providerConfig);
        boolean result = defaultProviderBootstra.inList("hello1", "hello2", "hello2");
        Assert.assertTrue(!result);
    }

    @Test
    public void notInListTest() {

        ProviderConfig providerConfig = new ProviderConfig();
        DefaultProviderBootstrap defaultProviderBootstra = new DefaultProviderBootstrap(providerConfig);
        boolean result = defaultProviderBootstra.inList("hello1", "hello2", "hello3");
        Assert.assertTrue(!result);
    }

    @Test
    public void PrefixIncludeListTest() {

        ProviderConfig providerConfig = new ProviderConfig();
        DefaultProviderBootstrap defaultProviderBootstra = new DefaultProviderBootstrap(providerConfig);
        boolean result = defaultProviderBootstra.inList("hello1", "hello1", "hello");
        Assert.assertTrue(!result);
    }
}