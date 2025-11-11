import React, { useState } from "react";

function MovieRecommendation() {
    const [actor, setActor] = useState('');
    const [genre, setGenre] = useState('');
    const [country, setCountry] = useState('');
    const [recommendations, setRecommendations] = useState('');

    const getRecommendations = async () => {
        try {
            const response = await fetch(
                `http://localhost:8080/movie-recommendation?actor=${actor}&genre=${genre}&country=${country}`
            );
            const data = await response.text();
            console.log(data);
            setRecommendations(data);
        } catch (error) {
            console.error("Error fetching movie recommendations:", error);
        }
    };

    return (
        <div className="movie-recommendation-container">
            <h2>🎬 Movie Recommendation System</h2>

            <input
                type="text"
                value={actor}
                onChange={(e) => setActor(e.target.value)}
                placeholder="Enter actor name"
            />

            <input
                type="text"
                value={genre}
                onChange={(e) => setGenre(e.target.value)}
                placeholder="Enter genre (e.g. action, drama)"
            />

            <input
                type="text"
                value={country}
                onChange={(e) => setCountry(e.target.value)}
                placeholder="Enter country"
            />

            <button onClick={getRecommendations}>Get Recommendations</button>

            <div className="output">
                <pre className="recommendation-text">{recommendations}</pre>
            </div>
        </div>
    );
}

export default MovieRecommendation;
