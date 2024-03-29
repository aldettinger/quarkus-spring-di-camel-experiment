/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.apache.aldettinger.quarkusspringdicamelexperiment;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;

/**
 * A "camel-quarkus" application using "quarkus-spring-di"
 */
//@SpringBootApplication could be translated into @ApplicationScoped in this case but this transformation can't be generalized.
@ApplicationScoped
@ImportResource(locations={"classpath:spring/camel-context.xml"}) // It is ignored at runtime, so ok. However, there is no build time error reported, is it misleading for users ?
public class Application extends RouteBuilder {

    @Autowired
    GreeterBean greeterBean;

    @Override
    public void configure() throws Exception {
        from("timer://foo?period=5000").setHeader("name", constant("world-header")).bean(greeterBean).log(">>> ${body}");
    }
}
