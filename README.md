# Project 2 - *Flicks*

**Flicks** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: **19** hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **scroll through current movies** from the Movie Database API

The following **stretch** features are implemented:

* For each movie displayed, user can see the following details:
  * [X] Title, Poster Image, Overview (Portrait mode)
  * [X] Title, Backdrop Image, Overview (Landscape mode)
* [X] Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
* [X] Allow user to view details of the movie including ratings and popularity within a separate activity
* [X] Improved the user interface by experimenting with styling and coloring.
* [X] Apply rounded corners for the poster or background images using [Glide transformations](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#transformations)
* [ ] Apply the popular [Butterknife annotation library](http://guides.codepath.org/android/Reducing-View-Boilerplate-with-Butterknife) to reduce boilerplate code (only installed and read)
* [X] Allow video trailers to be played in full-screen using the YouTubePlayerView from the details screen.

The following **additional** features are implemented:

* [x] Created a logo and made a splash screen
* [x] Got reviews from a separate path in movieDB and displayed it in details page


## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='walkthrough.gif' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

I didn't know the stretch goals had guides to go with them so I did them on my own but I think I didn't use the best methods since there was some repetitive code in my overall app. 

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
