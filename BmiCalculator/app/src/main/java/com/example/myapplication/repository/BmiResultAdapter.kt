package com.example.myapplication.repository

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class BmiResultAdapter(private val bmiMeasurementSet: List<BmiMeasurement>) :
    RecyclerView.Adapter<BmiResultAdapter.BmiViewHolder>() {
    class BmiViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bmiResult: TextView = view.findViewById(R.id.bmiResult)
        val weight: TextView = view.findViewById(R.id.weight)
        val massUnit: TextView = view.findViewById(R.id.weight_unit)
        val height: TextView = view.findViewById(R.id.height)
        val heightUnit: TextView = view.findViewById(R.id.height_unit)
        val date: TextView = view.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BmiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bmi_result_adapter_item, parent, false)
        return BmiViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return bmiMeasurementSet.size
    }

    override fun onBindViewHolder(holder: BmiViewHolder, position: Int) {
        val bmiMeasurement = bmiMeasurementSet[position]

        holder.bmiResult.text = bmiMeasurement.bmiResult.toString()
        holder.weight.text = bmiMeasurement.weight.toString()
        holder.massUnit.setText(bmiMeasurement.bmiUnit.weight)
        holder.height.text = bmiMeasurement.height.toString()
        holder.date.text = bmiMeasurement.date
        holder.heightUnit.setText(bmiMeasurement.bmiUnit.height)
        holder.bmiResult.setTextColor(ContextCompat.getColor(holder.bmiResult.context, bmiMeasurement.bmiCategory.color))
    }

}