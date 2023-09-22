import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Button, ButtonGroup } from "reactstrap";
import { Pokemon } from "./types/pokemonType";

function App() {
  const [pokemons, setPokemons] = useState<Pokemon[]>([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch("http://127.0.0.1:8080/api/pokemons")
      .then((response) => response.json())
      .then((data) => {
        setPokemons(data);
        setLoading(false);
      });
  }, []);

  async function remove(id: number) {
    await fetch(`http://127.0.0.1:8080/api/pokemon/${id}`, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then(() => {
      const updatedPokemons = [...pokemons].filter((i) => i.id !== id);
      setPokemons(updatedPokemons);
    });
  }

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <div className="p-5">
      <div className="d-flex justify-content-between">
        <h1>Pokemon CRUD</h1>
        <Button color="success" tag={Link} to="/pokemons/new">
          Add Group
        </Button>
      </div>
      <table className="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>
          {pokemons.map((pokemon) => (
            <tr key={pokemon.id}>
              <th scope="row">{pokemon.id}</th>
              <td>{pokemon.name}</td>
              <ButtonGroup>
                <Button
                  size="sm"
                  color="primary"
                  tag={Link}
                  to={"/pokemons/" + pokemon.id}
                >
                  Edit
                </Button>
                <Button
                  size="sm"
                  color="danger"
                  onClick={() => remove(pokemon.id)}
                >
                  Delete
                </Button>
              </ButtonGroup>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
