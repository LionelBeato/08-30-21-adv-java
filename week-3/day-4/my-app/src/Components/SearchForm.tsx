import React from "react";

interface Props {
    search(query: string): void; 
}

const SearchForm: React.FC<Props> = (props) => {
    function handleSubmit(e: React.FormEvent) {
        e.preventDefault(); 
        const formData = new FormData(e.target as HTMLFormElement);
        props.search((formData.get('query') || '') as string);
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                Query:
                <br />
                <input type="text" name="query" />
            </label>
            <button>Search</button>
        </form>
    )
}

export default SearchForm; 