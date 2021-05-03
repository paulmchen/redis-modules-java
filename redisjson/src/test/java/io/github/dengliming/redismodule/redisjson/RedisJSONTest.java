/*
 * Copyright 2021 dengliming.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.dengliming.redismodule.redisjson;

import io.github.dengliming.redismodule.redisjson.args.SetArgs;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author dengliming
 */
public class RedisJSONTest extends AbstractTest {

    @Test
    public void testSet() {
        RedisJSON redisJSON = getRedisJSON();
        String key = "foo";
        assertThat(redisJSON.set(key, SetArgs.Builder.create(".", "\"bar\""))).isEqualTo("OK");
        assertThat(redisJSON.set(key, SetArgs.Builder.nx(".", "\"bar\""))).isNull();
        assertThat(redisJSON.set(key, SetArgs.Builder.xx(".", "\"bar\""))).isEqualTo("OK");
        assertThat(redisJSON.del(key, ".")).isEqualTo(1);
    }
}