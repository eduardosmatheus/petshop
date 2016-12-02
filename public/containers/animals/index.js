import React, { Component } from 'react'
import { connect } from 'react-redux'
import { Link } from 'react-router'

import { fetchAnimals, createAnimal, updateAnimal, deleteAnimal, getAnimal, clearActualAnimal, filterAnimal } from '../../actions/ActionsAnimal'
import { fetchCustomers } from '../../actions/ActionsCustomer'
import { fetchEspecies } from '../../actions/ActionsEspecie'
import { fetchBreeds } from '../../actions/ActionsBreed'
import { openModal, closeModal } from '../../actions/ActionsModal'

import AnimalForm from './form'
import GridHeader from '../../components/GridHeader'

class Animals extends Component {

  componentWillMount() {
    if(!this.props.children) {
      this.props.fetchAnimals();
      this.props.fetchEspecies();
      this.props.fetchBreeds();
      this.props.fetchCustomers();
    }
  }

  _buildModalStateToEdit() {
    return {
      modalTitle : "Editar Animal",
      contentRender : () => { return (<AnimalForm action={(param) => {
        let animal = ::this._buildImmutableAnimal(param);
        ::this.props.closeModal();
        ::this.props.updateAnimal(animal);
      }}/>)}
    }
  }

  _buildImmutableAnimal(param) {
    let { breeds, especies, customers } = this.props

    let animal = Object.assign(param);
    let breedId = animal.breed;
    animal.breed = breeds.reduce((acc, current) => {
      if(current.id == breedId)
        return current;
      return acc;
    }, { id: '' });

    let especieId = animal.especie;
    animal.especie = especies.reduce((acc, current) => {
      if(current.id == especieId)
        return current;
      return acc;
    }, { id: '' });

    let customerId = animal.customer;
    animal.customer = customers.reduce((acc, current) => {
      if(current.id == customerId)
        return current
      return acc;
    }, { id: '' });

    return animal
  }


  _buildModalStateToAdd() {
    return {
      modalTitle : "Adicionar Animal",
      contentRender : () => { return (<AnimalForm action={(param) => {
        let animal = ::this._buildImmutableAnimal(param);
        ::this.props.closeModal();
        ::this.props.createAnimal(animal);
      }}/>)}
    }
  }

  _renderChildrens() {
    if(this.props.children)
      return (<div>{this.props.children}</div>)

    let { all } = this.props.animals;
    return  (
      <div>
        <GridHeader
          openModal={ ()=> {
            ::this.props.clearActualAnimal();
            ::this.props.openModal(this._buildModalStateToAdd());
          }}
          onChangeSearch={ (text) => {::this.props.filterAnimal(text)}}
        />
        <div className="columns is-multiline">
          {all.map((pet, i) => {
            return ( <div key={pet.id} className="column is-one-third area-item animal-card">
              <div className="card is-fullwidth">
                <header className="card-header">
                  <p className="card-header-title">
                    { pet.name }
                 </p>
               </header>
                <div className="card-content">
                  <br/>
                  <div className="content">
                    <p>Dono: { pet.customer.name }</p>
                    <p>Raça: { pet.breed.name }</p>
                    <p>Especie: { pet.especie.description }</p>
                    {pet.obs && <blockquotes> { pet.obs } </blockquotes>}
                    <br/>
                    <small>Nascimento:<strong> {new Date(pet.birth).toString("YYYY-MM-DD")} </strong> </small>
                  </div>
                </div>
                <footer className="card-footer">
                  <a className="card-footer-item" onClick={() =>{
                    ::this.props.getAnimal(pet.id);
                    ::this.props.openModal(this._buildModalStateToEdit());
                  }}>Edit</a>
                  <a className="card-footer-item" onClick={() => {
                    ::this.props.deleteAnimal(pet)
                  }}>Delete</a>
                </footer>
              </div>
            </div> )
          })}
        </div>
      </div>)
  }


  render() {
    let { pathname } = this.props.location
    return (<div>
              <h3 className="title is-3">Pets</h3>
              <div className="tabs is-centered is-boxed is-medium">
                <ul>
                  <li className={pathname == '/animals' ? 'is-active' : ''}>
                    <Link to="/animals">
                      <span>Pets</span>
                    </Link>
                  </li>
                  <li className={pathname == '/animals/breeds' ? 'is-active' : ''}>
                    <Link to="/animals/breeds">
                      <span>Raças</span>
                    </Link>
                  </li>
                  <li className={pathname == '/animals/especies' ? 'is-active' : ''}>
                    <Link to="/animals/especies">
                      <span>Especies</span>
                    </Link>
                  </li>
                </ul>
              </div>
              <div className="container">
                {this._renderChildrens()}
              </div>
            </div>)
  }
}

function mapStateToProps(state) {
  return {
    breeds : state.breedState.all,
    especies : state.especieState.all,
    customers : state.customerState.all,
    animals : state.animalsState
  }
}

export default connect(mapStateToProps, { fetchAnimals, createAnimal, updateAnimal, deleteAnimal,
  getAnimal, clearActualAnimal, filterAnimal, openModal, closeModal,  fetchEspecies, fetchBreeds, fetchCustomers })(Animals)
