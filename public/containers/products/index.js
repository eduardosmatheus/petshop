import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchProducts, createProduct, updateProduct, deleteProduct, getProduct, clearActualProduct, filterProduct } from '../../actions/ActionsProduct'
import { openModal, closeModal } from '../../actions/ActionsModal'
import { Link } from 'react-router'

import ProductForm from './form'
import GridHeader from '../../components/GridHeader'


class Products extends Component {

  componentWillMount() {
    if(!this.props.children)
      this.props.fetchProducts()
  }

  _buildModalStateToEdit() {
    return {
      modalTitle : "Editar Produto",
      contentRender : () => { return (<ProductForm action={(product) => {
        ::this.props.closeModal()
        ::this.props.updateProduct(product)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualProduct() }
    }
  }

  _buildModalStateToAdd() {
    return {
      modalTitle : "Adicionar Produto",
      contentRender : () => { return (<ProductForm action={(product) => {
        ::this.props.closeModal()
        ::this.props.createProduct(product)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualProduct() }
    }
  }

  render() {
    return (
      <div>
        <h3 className="title is-3">Produtos</h3>
        <GridHeader
          openModal={ ()=> {
            ::this.props.clearActualProduct()
            ::this.props.openModal(this._buildModalStateToAdd())
          }}
          onChangeSearch={ (text) => {::this.props.filterProduct(text)}}
        />
        <div className="columns is-multiline">
          {this.props.products.all.map(( product ) => {
            return (<div className="column is-one-third area-item animal-card" key={product.id}>
                <div className="card is-fullwidth">
                  <header className="card-header">
                    <p className="card-header-title">
                    { product.description }
                    </p>
                  </header>
                  <div className="card-content">
                    <div className="media">
                      <div className="media-content">
                        <p>Custa <strong>{ product.price } R$</strong> e ainda existem <strong>{ product.stockAmount }</strong> unidades em estoque.</p>
                      </div>
                    </div>
                  </div>
                  <footer className="card-footer">
                    <a className="card-footer-item" onClick={() => {
                      this.props.getProduct(product.id)
                      this.props.openModal(this._buildModalStateToEdit())
                    }}>Edit</a>
                    <a className="card-footer-item" onClick={() => {this.props.deleteProduct(product)} }>Delete</a>
                  </footer>
                </div>
              </div>) }
          )}
        </div>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { products : state.productsState }
}

export default connect(mapStateToProps,
  { fetchProducts, getProduct, deleteProduct, createProduct, updateProduct, clearActualProduct, filterProduct, closeModal, openModal })(Products)
