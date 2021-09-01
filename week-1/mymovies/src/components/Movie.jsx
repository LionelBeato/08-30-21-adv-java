import React from 'react'; 

export const Movie = ({title, releaseDate}) => {
    return (
        <div>
            <ul>
                <li>{title}</li>
                <li>{releaseDate}</li>
            </ul>
        </div>
    )
}