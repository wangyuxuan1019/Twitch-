package com.archtect.twitch.external.model;

import java.util.List;

public record StreamResponse(
        List<Stream> data
) {
}
