/*
 * Copyright (C) 2016 Lloyd Chan
 *
 * Licensed either under the Apache License, Version 2.0, or (at your option)
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation (subject to the "Classpath" exception),
 * either version 2, or any later version (collectively, the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     http://www.gnu.org/licenses/
 *     http://www.gnu.org/software/classpath/license.html
 *
 * or as provided in the LICENSE.txt file that accompanied this code.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bytedeco.javacpp.presets;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

/**
 * @author Lloyd @ github.com/lloydmeta
 */
@Properties(value = @Platform(
        define = "_MSVC_COMPAT__",
        include = {"CLandmark.h", "Flandmark.h", "CFeaturePool.h", "CFeatures.h", "CImg.h"},
        link = { "clandmark@.1.5", "flandmark@.1.5"}),
        inherit = opencv_imgproc.class, target = "org.bytedeco.javacpp.clandmark")
public class clandmark implements InfoMapper {
    public void map(InfoMap infoMap) {
        infoMap.put(new Info("fl_double_t", "clandmark::fl_double_t").cast().valueTypes("float").pointerTypes("FloatPointer").define());
        infoMap.put(new Info("METHODDEF").cppText("#define METHODDEF(type) static type"));
        infoMap.put(new Info("unsigned char").translate().valueTypes("byte").pointerTypes("BytePointer"));
        infoMap.put(new Info("cimg_library::CImg<unsigned char>").pointerTypes("ByteCImg").define());
    }
}
