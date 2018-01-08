project(bgdc C)
cmake_minimum_required(VERSION 3.4)
# Required stuff
set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${bgdc_SOURCE_DIR}/../include")
find_package(SDL2 2.0.4 REQUIRED)
find_package(ZLIB REQUIRED)
# Preprocessor macros
add_definitions(-D__BGDC__)

# Common defines
include(common_defs)

# Source files
file(GLOB SOURCE_FILES
  ${bgdc_SOURCE_DIR}/../../../core/bgdc/src/*.c
  ${bgdc_SOURCE_DIR}/../../../core/common/debug.c
  ${bgdc_SOURCE_DIR}/../../../core/common/files.c
  ${bgdc_SOURCE_DIR}/../../../core/common/xctype.c)
# Include dirs
include_directories(${bgdc_SOURCE_DIR}/../../../core/bgdc/include
                    ${bgdc_SOURCE_DIR}/../../../core/include
                    ${bgdc_SOURCE_DIR}/../../../modules/libbgload/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_debug/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_say/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_string/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_math/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_mem/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_time/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_file/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_sound/
                    ${bgdc_SOURCE_DIR}/../../../modules/libsdlhandler/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_joy/
                    ${bgdc_SOURCE_DIR}/../../../modules/libjoy/
                    ${bgdc_SOURCE_DIR}/../../../modules/libkey/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_key/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_proc/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_sort/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_timers/
                    ${bgdc_SOURCE_DIR}/../../../modules/libgrbase/
                    ${bgdc_SOURCE_DIR}/../../../modules/libblit/
                    ${bgdc_SOURCE_DIR}/../../../modules/libvideo/
                    ${bgdc_SOURCE_DIR}/../../../modules/librender/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_video/
                    ${bgdc_SOURCE_DIR}/../../../modules/libmouse/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_mouse/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_multi/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_map/
                    ${bgdc_SOURCE_DIR}/../../../modules/libfont/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_dir/
                    ${bgdc_SOURCE_DIR}/../../../modules/libtext/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_text/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_rand/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_grproc/
                    ${bgdc_SOURCE_DIR}/../../../modules/libscroll/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_scroll/
                    ${bgdc_SOURCE_DIR}/../../../modules/libdraw/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_draw/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_screen/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_path/
                    ${bgdc_SOURCE_DIR}/../../../modules/libwm/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_wm/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_sys/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_regex/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_effects/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_blendop/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_m7/
                    ${bgdc_SOURCE_DIR}/../../../modules/mod_flic/
                    ${SDL2_INCLUDE_DIR}
                    ${ZLIB_INCLUDE_DIRS})

# In windows? Add an icon and link agains shlwapi
if(WIN32)
	set(SOURCE_FILES
        ${SOURCE_FILES}
        ${bgdc_SOURCE_DIR}/bgdc.rc)
    set(EXTRA_LIBS "shlwapi")
else()
    set(EXTRA_LIBS)
endif()

# Main executable
add_executable(${PROJECT_NAME} ${SOURCE_FILES})

# Include the compiler flags from the external include file
include(compiler_flags)

# Link the executable to the libraries
target_link_libraries(${PROJECT_NAME} ${ZLIB_LIBRARIES} ${EXTRA_LIBS})

# Installation instructions
if(WIN32)
    set(INSTALL_BIN_DIR "${CMAKE_INSTALL_PREFIX}/bin/win32" CACHE PATH "Installation directory for executables")
elseif(APPLE)
    set(INSTALL_BIN_DIR "${CMAKE_INSTALL_PREFIX}/bin/osx32" CACHE PATH "Installation directory for executables")
else()
    set(INSTALL_BIN_DIR "${CMAKE_INSTALL_PREFIX}/bin/gnulinux32" CACHE PATH "Installation directory for executables")
endif()
install(TARGETS ${PROJECT_NAME}
        RUNTIME DESTINATION "${INSTALL_BIN_DIR}")