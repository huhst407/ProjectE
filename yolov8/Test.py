import onnx

# 加载模型
model = onnx.load("best.onnx")

# 获取模型的输入
inputs = model.graph.input
for input in inputs:
    print("Name:", input.name)
    print("Shape:", [dim.dim_value for dim in input.type.tensor_type.shape.dim])

# 获取模型的输出
outputs = model.graph.output
for output in outputs:
    print("Name:", output.name)
    print("Shape:", [dim.dim_value for dim in output.type.tensor_type.shape.dim])