import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { Button, Container, Form, FormGroup, Input, Label } from "reactstrap";
import { Pokemon } from "../src/types/pokemonType";

function PokemonEdit() {
  const initialFormState = {
    name: "",
  };
  const [pokemon, setPokemon] = useState<Pokemon>(initialFormState);
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id !== "new") {
      fetch(`http://127.0.0.1:8080/api/pokemon/${id}`)
        .then((response) => response.json())
        .then((data) => setPokemon(data));
    }
  }, [id, setPokemon]);

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;

    setPokemon({ ...pokemon, [name]: value });
  };

  const handleSubmit = async (event: React.FormEvent) => {
    event.preventDefault();

    await fetch(
      `http://127.0.0.1:8080/api/pokemon${pokemon.id ? `/${pokemon.id}` : ""}`,
      {
        method: pokemon.id ? "PUT" : "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(pokemon),
      }
    );
    setPokemon(initialFormState);
    navigate("/");
  };

  const title = <h2>{pokemon.id ? "Edit Pokemon" : "Add Pokemon"}</h2>;

  return (
    <div>
      <Container>
        {title}
        <Form onSubmit={handleSubmit}>
          <FormGroup>
            <Label for="name">Name</Label>
            <Input
              type="text"
              name="name"
              id="name"
              value={pokemon.name || ""}
              onChange={handleChange}
              autoComplete="name"
            />
          </FormGroup>
          <FormGroup>
            <Button color="primary" type="submit">
              Save
            </Button>{" "}
            <Button color="secondary" tag={Link} to="/">
              Cancel
            </Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  );
}

export default PokemonEdit;
