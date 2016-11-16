import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchBreeds, deleteBreed } from '../../../actions/ActionsBreed'
import BreedForm from './BreedForm'
import { Link } from 'react-router'

class Breeds extends Component {

  componentWillMount() {
    if(!this.props.children)
      this.props.fetchBreeds()
  }

  renderBreeds() {
    return this.props.breeds.all.map((breed) => {
      return (
        <tr key={breed.id}>
          <td>{breed.id}</td>
          <td>{breed.name}</td>
          <td>
            <Link to={`/breeds/edit/${breed.id}`}>
              <button className="btn btn-warning">
              Editar
              </button>
            </Link>
          </td>
          <td>
            <button className="btn btn-danger" onClick={() => {this.props.deleteBreed(breed.id)} }>
            Excluir
            </button>
          </td>
        </tr>)
    })
  }

  render() {
    let { actual } = this.props.breeds

    if(this.props.children)
      return (<div>{ this.props.children }</div>)

    return (
      <div>

        <table className="table table-striped table-hover ">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nome</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {this.renderBreeds()}
          </tbody>
        </table>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { breeds : state.breedState }
}

export default connect(mapStateToProps, { fetchBreeds, deleteBreed })(Breeds)
