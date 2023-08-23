/*
 * Copyright 2019 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.centraldogma.server.mirror;

import static java.util.Objects.requireNonNull;

/**
 * A utility class for creating a mirroring task.
 */
public final class MirrorUtil {

    /**
     * Normalizes the specified {@code path}. A path which starts and ends with {@code /} would be returned.
     * Also, it would not have consecutive {@code /}.
     */
    public static String normalizePath(String path) {
        requireNonNull(path, "path");
        if (path.isEmpty()) {
            return "/";
        }

        if (!path.startsWith("/")) {
            path = '/' + path;
        }

        if (!path.endsWith("/")) {
            path += '/';
        }

        return path.replaceAll("//+", "/");
    }

    private MirrorUtil() {}
}
