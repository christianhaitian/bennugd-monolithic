project(bgdi C)
cmake_minimum_required(VERSION 3.4)
# Require pxtrtm
add_subdirectory(bgdrtm)
# Required stuff
set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${bgdi_SOURCE_DIR}/../include")
find_package(SDL2 2.0.4 REQUIRED)
find_package(SDL2_Mixer REQUIRED)
find_package(ZLIB REQUIRED)
find_package(PNG REQUIRED)
find_package(OGG REQUIRED)
find_package(Vorbis REQUIRED)
find_package(TRE REQUIRED)
# Preprocessor macros
add_definitions(-D__BGDI__)
include(common_defs)
# Source files
set(SOURCE_FILES
  ${bgdi_SOURCE_DIR}/../../../core/bgdi/include/bgdi.h
  ${bgdi_SOURCE_DIR}/../../../core/bgdi/src/main.c)
# Include dirs
include_directories(${bgdi_SOURCE_DIR}/../../../core/bgdi/include
                    ${bgdi_SOURCE_DIR}/../../../core/include
                    ${bgdi_SOURCE_DIR}/../../../core/bgdrtm/include/)

if(WIN32)
    set(EXTRA_LIBS "-lshlwapi -lwsock32 -lm")
	set(SOURCE_FILES
      ${SOURCE_FILES}
      ${bgdi_SOURCE_DIR}/bgdi.rc)
else()
    set(EXTRA_LIBS "-lm")
endif()

# Main executable
add_executable(${PROJECT_NAME} ${SOURCE_FILES})

# Include the compiler flags from the external include file
include(compiler_flags)

# Link the executable to the libraries
target_link_libraries(${PROJECT_NAME}
                      bgdrtm
                      ${SDL2_LIBRARY}
                      ${SDL2_MIXER_LIBRARIES}
                      ${ZLIB_LIBRARIES}
                      ${PNG_LIBRARIES}
                      ${TRE_LIBRARY}
                      ${OGG_LIBRARY}
                      ${VORBIS_LIBRARY}
                      ${EXTRA_LIBS})

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
