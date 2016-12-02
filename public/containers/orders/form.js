import React, { Component } from 'react'
import Select, { Creatable } from 'react-select'
import { addItemToList } from '../../actions/ActionsOrder'
import { reduxForm, change as changeFieldValue } from 'redux-form'
import { parseTimeStringFormatToMillisecods, parseMillisecodsToTimeStringFormat } from '../../dateParser'


class OrderForm extends Component {

  _parseFormToState(form) {

    let employeer = this.props.employeersState.all.reduce((acc, act) => {
      if(form.employeer == act.id)
        return act;
      return acc;
    });

    let pet = this.props.animalsState.all.reduce((acc, act) => {
      if(form.pet == act.id)
        return act;
      return acc;
    });

    let itens = form.itens.map((item) => {
      let itemFromState = this.props.productsState.all.reduce((acc, act) => {
        if(item.id == act.id)
          return act;
        return acc;
      })
      return {
        id: '',
        item: itemFromState,
        amount: item.amountProd,
        unitPrice: item.priceProd
      }
    });

    return {
      id: '',
      accessKey: form.accessKey,
      price: form.price,
      appointment: {
        id: '',
        appointmentConfig: {
          ...employeer.appointmentConfig,
          employeers_id: employeer.id
        },
        pet: pet,
        date: form.date,
        entryTime: parseTimeStringFormatToMillisecods(form.entryTime),
        outTime: parseTimeStringFormatToMillisecods(form.outTime),
        done: 0,
        obs: ''
      },
      itens: itens
    };
  }

  render() {
    let { fields : { id, accessKey, pet, price, employeer, date, entryTime, outTime, product, priceProd, amountProd }, animalsState, employeersState, productsState } = this.props

    return (
      <form onSubmit={

        this.props.handleSubmit((form) => {
          form.itens = this.props.ordersState.actual.listItensTemp;
          form = this._parseFormToState(form);
          this.props.action(form);
        })

      }>
        <p className="control has-icon has-icon-right">
          <input type="hidden" className="input" { ...id } readOnly/>
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Descrição do serviço:</label>
          <input type="text" className={`input ${accessKey.error && accessKey.touched ? `is-danger` : ``} `} {...accessKey} maxLength='60'/>
          {accessKey.error && accessKey.touched && <i className="fa fa-warning"></i>}
          {accessKey.error && accessKey.touched && <span className="help is-danger">{ accessKey.error }</span>}
        </p>
        <div className="control">
          <label className="label">Pet:</label>
          <Select
            {...pet}
            options={animalsState.all.map((pet) => {  return {value: pet.id, label: (pet.name + ' - ' + pet.customer.name + ' / ' + pet.customer.cpf) } } )}
            onBlur={() => pet.onBlur(pet.value)}/>
        </div>
        <p className="control has-icon has-icon-right">
          <label className="label">Preço do serviço:</label>
          <input type="number" className={`input ${price.error && price.touched ? `is-danger` : ``} `} {...price} maxLength='60'/>
          {price.error && price.touched && <i className="fa fa-warning"></i>}
          {price.error && price.touched && <span className="help is-danger">{ price.error }</span>}
        </p>
        <div className="control">
          <label className="label">Empregado responsável:</label>
          <Select
            {...employeer}
            options={employeersState.all.map((employeer) => {  return {value: employeer.id, label: employeer.name } } )}
            onBlur={() => employeer.onBlur(employeer.value)}/>
        </div>
        <p className="control has-icon has-icon-right">
          <label className="label">Data planejada para executar o serviço:</label>
          <input type="date" className={`input ${date.error && date.touched ? `is-danger` : ``} `} {...date} maxLength='60'/>
          {date.error && date.touched && <i className="fa fa-warning"></i>}
          {date.error && date.touched && <span className="help is-danger">{ date.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          Horários vagos para a data:
          {
            date.value && this.props.ordersState.all.filter(order => {
                return order.appointment.done == 0 && order.appointment.appointmentConfig.employeers_id == employeer.value && order.appointment.date == date.value;
              }).map((order, i) => {
                  return (<label className="label" keys={i}>
                    { parseMillisecodsToTimeStringFormat(order.appointment.entryTime) + ' - ' + parseMillisecodsToTimeStringFormat(order.appointment.outTime) }
                  </label>);
            })
          }
        </p>

        <p className="control has-icon has-icon-right">
          <label className="label">Inicio às:</label>
          <input type="time" className={`input ${entryTime.error && entryTime.touched ? `is-danger` : ``} `} {...entryTime} maxLength='60'/>
          {entryTime.error && entryTime.touched && <i className="fa fa-warning"></i>}
          {entryTime.error && entryTime.touched && <span className="help is-danger">{ entryTime.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Fim planejado às:</label>
          <input type="time" className={`input ${outTime.error && outTime.touched ? `is-danger` : ``} `} {...outTime} maxLength='60'/>
          {outTime.error && outTime.touched && <i className="fa fa-warning"></i>}
          {outTime.error && outTime.touched && <span className="help is-danger">{ outTime.error }</span>}
        </p>
        <div className="control" style={{backgroundColor: '#F1F1F1'}}>
          <div className="columns">
            <div className="column">
              <label className="label">Item:</label>
            </div>
            <div className="column">
              <label className="label">Preço:</label>
            </div>
            <div className="column">
              <label className="label">Quantidade:</label>
            </div>
            <div className="column">
            </div>
          </div>
          <div className="columns">
            <div className="column">
              <Select
                {...product}
                options={productsState.all.map((product) => {  return {value: product.id, label: product.description } } )}
                onBlur={() => product.onBlur(product.value)}/>
            </div>
            <div className="column">
              <input type="number" className="input" {...priceProd} maxLength='60'/>
            </div>
            <div className="column">
              <input type="number" className="input" {...amountProd} maxLength='60'/>
            </div>
            <div className="column">
              <input type="button" className="button is-primary" value="Adicionar Produto" onClick={() => {
                this.props.addItemToList({ id: product.value, priceProd: priceProd.value, amountProd: amountProd.value});
                this.props.changeFieldValue('OrderForm','product','');
                this.props.changeFieldValue('OrderForm','priceProd','0');
                this.props.changeFieldValue('OrderForm','amountProd','0');
              }}/>
            </div>
          </div>
          Lista de produtos assiados:
          <div className="control">
               {this.props.ordersState.actual.listItensTemp.map((o, i) => {
                 return(<div className="columns" key={i}>
                      <div className="column">
                        <label className="label">{productsState.all.filter((a) => a.id == o.id).map((prod) => {
                          return prod.description
                        })}</label>
                      </div>
                      <div className="column">
                        <label className="label">{o.priceProd}</label>
                      </div>
                      <div className="column">
                        <label className="label">{o.amountProd}</label>
                      </div>
                    </div>)
               })}
          </div>
        </div>
        <p className="control">
          <button type="submit"  className="button is-primary">Gravar</button>
        </p>
      </form>
    )
  }
}

function mapStateToProps(state) {
  return {
    animalsState: state.animalsState,
    productsState: state.productsState,
    employeersState: state.employeersState,
    ordersState: state.ordersState,
    initialValues : {}
  }
}

export default reduxForm({
  form : 'OrderForm',
  fields : ['id', 'accessKey', 'pet', 'price', 'employeer', 'date', 'entryTime', 'outTime', 'product', 'priceProd', 'amountProd'],
  validate : (values) => {
    let error = {}
    if(!values.accessKey)
      error.accessKey = 'Informe uma descrição para o serviço.';

    if(!values.pet)
      error.pet = 'Informe um pet para o serviço.';

    if(!values.price)
      error.price = 'Informe um preço de mão de obra para o serviço.';

    if(!values.employeer)
      error.employeer = 'Informe um Empregado para o serviço.';

    if(!values.date)
      error.date = 'Informe uma Data para o serviço.';

    if(!values.entryTime)
      error.entryTime = 'Informe uma hora inicio para o serviço.';

    if(!values.outTime)
      error.outTime = 'Informe uma hora fim para o serviço.';

    return error;
  }

}, mapStateToProps, { changeFieldValue, addItemToList })(OrderForm)
